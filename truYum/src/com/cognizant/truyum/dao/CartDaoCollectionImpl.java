package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
//	public long userId;
	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();

		if (userCarts == null) {
			userCarts = new HashMap<>();
			// userCarts.put(userID, menuItemList);
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) throws Exception {
		List<MenuItem> menuItemList;
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			menuItemList = cart.getMenuItemList();

			if (menuItemList == null) {
				menuItemList = new ArrayList<MenuItem>();
				menuItemList.add(menuItem);
				cart.setMenuItemList(menuItemList);
				userCarts.put(userId, cart);
			}

		} else {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);

			Cart cart = new Cart(menuItemList, menuItem.getPrice());
			userCarts.put(userId, cart);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		double total = 0;

		Cart cart = getUserCarts().get(userId);
		List<MenuItem> menuItemList = cart.getMenuItemList();

		if (menuItemList == null || menuItemList.size() == 0) {
			throw new CartEmptyException();
		}

		for (MenuItem menuItem : menuItemList) {
			total += menuItem.getPrice();
		}

		cart.setTotal(total);

		return menuItemList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		userCarts = getUserCarts();

		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);

			List<MenuItem> menuItemList = cart.getMenuItemList();

			if (menuItemList != null || menuItemList.size() > 0) {
				for (int i = 0; i < menuItemList.size(); i++) {
					MenuItem menuItem = menuItemList.get(i);
					
					if (menuItem.getId() == menuItemId) {
						menuItemList.remove(menuItem);
					}
				}
			}
			
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);
		}

	}

	public static HashMap<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public static void setUserCarts(HashMap<Long, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}

}
