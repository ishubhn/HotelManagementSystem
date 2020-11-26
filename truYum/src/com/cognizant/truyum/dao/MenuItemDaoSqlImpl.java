package com.cognizant.truyum.dao;

import java.awt.image.DataBufferByte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	PreparedStatement st = null;
	MenuItem menuItem = null;
	ResultSet rs = null;

	@SuppressWarnings("rawtypes")
	List menuItemList;

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		try {
			String query = "SELECT * FROM MENU_ITEM";
			st = ConnectionHandler.getConnection().prepareStatement(query);
			menuItemList = new ArrayList<MenuItem>();
			rs = st.executeQuery();

			while (rs.next()) {
				menuItemList.add(rs.getLong(1));
				menuItemList.add(rs.getString(2));
				menuItemList.add(rs.getFloat(3));
				menuItemList.add(rs.getBoolean(4));
				menuItemList.add(rs.getDate(5));
				menuItemList.add(rs.getString(6));
				menuItemList.add(rs.getBoolean(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItemList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		try {
			String query = "SELECT * FROM MENU_ITEM WHERE ISACTIVE = TRUE AND DATEOFLAUNCH >= CURDATE()";
			menuItemList = new ArrayList<MenuItem>();
			st = ConnectionHandler.getConnection().prepareStatement(query);
			rs = st.executeQuery();

			while (rs.next()) {
				menuItemList.add(rs.getLong(1));
				menuItemList.add(rs.getString(2));
				menuItemList.add(rs.getFloat(3));
				menuItemList.add(rs.getBoolean(4));
				menuItemList.add(rs.getDate(5));
				menuItemList.add(rs.getString(6));
				menuItemList.add(rs.getBoolean(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItemList;
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		try {
			String query = "SELECT * FROM MENU_ITEM WHERE MENUITEMID = ?";
			menuItem = new MenuItem();
			menuItemList = new ArrayList<MenuItem>();

			st = ConnectionHandler.getConnection().prepareStatement(query);
			st.setLong(1, menuItemId);
			rs = st.executeQuery();

			while (rs.next()) {
				menuItem.setId(rs.getLong(1));
				menuItem.setName(rs.getString(2));
				menuItem.setPrice(rs.getFloat(3));
				menuItem.setActive(rs.getBoolean(4));
				menuItem.setDateOfLaunch(rs.getDate(5));
				menuItem.setCategory(rs.getString(6));
				menuItem.setFreeDelivery(rs.getBoolean(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String date = df.format(menuItem.getDateOfLaunch());

		String query = "UPDATE MENU_ITEM SET TITLE = " + menuItem.getName() + ", PRICE = " + menuItem.getPrice()
				+ ", ISACTIVE = " + menuItem.isActive() + ", DATEOFLAUNCH = " + date
				+ ", CATEGORY = " + menuItem.getCategory() + ", ISFREEDELIVERY = " + menuItem.isFreeDelivery()
				+ " WHERE MENUITEMID = " + menuItem.getId();
		
		try {
			st = ConnectionHandler.getConnection().prepareStatement(query);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
