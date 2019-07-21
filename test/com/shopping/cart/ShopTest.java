package com.shopping.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.shopping.cart.model.Category;
import com.shopping.cart.model.Item;

public class ShopTest {

	private transient Shop shop;
	
	
	@Test
	public void  testCreateCategories() {
		shop = new Shop();
		List<Category> categoryList= shop.createCategories();
		assertEquals(categoryList.size(), 20);
	}
	
	@Test
	public void testDisplayStoreProducts() {
		shop = new Shop();
		shop.displayStoreProducts();
	}
	
	
	
	@Test
	public void testGenerateItems() {
		shop = new Shop();
		List<Item> itemList = shop.generateItems();
		assertEquals(itemList.size(), 10);
	}
	
	
}
