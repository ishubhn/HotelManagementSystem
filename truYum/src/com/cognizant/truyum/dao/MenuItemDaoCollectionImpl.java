package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private List<MenuItem> menuItemList;
	
	
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}

	/*METHODS V*/
	@Override
	public List<MenuItem> getMenuItemListtAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public MenuItem getMenuItem(long menuitemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
