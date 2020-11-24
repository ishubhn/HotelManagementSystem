package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws Exception {
		if (menuItemList == null) {

			menuItemList = new ArrayList<>();

			MenuItem m1 = new MenuItem(1l, "Sandwich", 99.00f, true, "15/03/2017", "Main Course", true);
			MenuItem m2 = new MenuItem(2l, "Burger", 129.00f, true, "23/12/2017", "Main Course", false);
			MenuItem m3 = new MenuItem(3l, "Pizza", 149.00f, true, "21/08/2018", "Main Course", false);
			MenuItem m4 = new MenuItem(4l, "French Fries", 57.00f, false, "02/07/2017", "Starters", true);
			MenuItem m5 = new MenuItem(5l, "Chocolate Brownie", 32.00f, true, "02/11/2022", "Dessert", true);

			menuItemList.add(m1);
			menuItemList.add(m2);
			menuItemList.add(m3);
			menuItemList.add(m4);
			menuItemList.add(m5);
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		//gives Current Date
		Date today = new Date();

		List<MenuItem> custList = new ArrayList<>();
		
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().before(today) && menuItem.isActive()) {
				custList.add(menuItem);
			}
		}
		
		return custList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		int i = 0;
		for (MenuItem item : menuItemList) {
			if(item.equals(menuItem)) {
				menuItemList.set(i, menuItem);
			}
			i++;	//pointer
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				return menuItem;
			}
		}
		return null;
	}


}
