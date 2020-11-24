package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {

	public void testGetMenuItemListAdmin() throws Exception {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> listAdmin = menuItemDao.getMenuItemListAdmin();

		for (MenuItem menuItem : listAdmin) {
			System.out.println(menuItem);
		}
	}

	public void testGetMenuItemListCustomer() throws Exception {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> listCust = menuItemDao.getMenuItemListCustomer();

		for (MenuItem menuItem : listCust) {
			System.out.println(menuItem);
		}
	}

	public void testModifyMenuItem() throws Exception {
		MenuItem item = new MenuItem(2l, "Burger", 129.00f, true, "23/12/2017", "Main Course", true);
		
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(item);
		System.out.println(menuItemDao.getMenuItem(2l));
		
	}

	public void testGetMenuItem() {

	}

	public static void main(String[] args) throws Exception {
		MenuItemDaoCollectionImplTest mTest = new MenuItemDaoCollectionImplTest();
//		mTest.testGetMenuItemListAdmin();
//		mTest.testGetMenuItemListCustomer();
		mTest.testModifyMenuItem();
	}
}
