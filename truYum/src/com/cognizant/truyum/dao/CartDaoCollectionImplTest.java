package com.cognizant.truyum.dao;

public class CartDaoCollectionImplTest {
	
	public void testAddCartItem() throws Exception {
		CartDao cartDao = new CartDaoCollectionImpl();
		
		cartDao.addCartItem(1, 4l);
		cartDao.addCartItem(1, 2l);
		
		System.out.println(cartDao.getAllCartItems(1));
	}

	public void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		
		System.out.println(cartDao.getAllCartItems(2));
	}

	public void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		
		cartDao.removeCartItem(1, 2l);
		try {
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		CartDaoCollectionImplTest cart = new CartDaoCollectionImplTest();
		
		cart.testAddCartItem();
		cart.testGetAllCartItems();
		cart.testRemoveCartItem();
	}
}
