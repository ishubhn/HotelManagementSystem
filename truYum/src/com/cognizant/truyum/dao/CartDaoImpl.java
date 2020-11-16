package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoImpl implements CartDao {

	private static HashMap<Long,Cart> userCarts;
	
	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
	}

	public static HashMap<Long,Cart> getUserCarts() {
		return userCarts;
	}

	public static void setUserCarts(HashMap<Long,Cart> userCarts) {
		CartDaoImpl.userCarts = userCarts;
	}

}
