package com.shopping.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;

import com.shopping.cart.model.CartItem;
import com.shopping.cart.model.Category;
import com.shopping.cart.model.Item;
import com.shopping.cart.util.ShoppingCartUtil;

public class CartTest {

	private transient Category category;

	private transient Item item;

	private transient CartItem cartItem;

	private transient List<Category> categoryList;

	private transient Cart cart = new Cart();

	@Before
	public void setupMock() {
		List<Item> itemList = new ArrayList<>();
		item = new Item("Item 1", 23.2, 2.4, 4.5);
		itemList.add(item);
		item = new Item("Item 2", 12.2, 3.0, 4.8);
		itemList.add(item);
		item = new Item("Item 3", 6.2, 2.4, 4.6);
		itemList.add(item);
		item = new Item("Item 4", 5.2, 2.4, 3.5);
		itemList.add(item);
		item = new Item("Item 5", 3.2, 7.4, 4.0);
		itemList.add(item);

		List<Item> itemList1 = new ArrayList<>();
		item = new Item("Item 6", 12.8, 2.4, 4.5);
		itemList1.add(item);
		item = new Item("Item 7", 10.2, 3.0, 4.8);
		itemList1.add(item);
		item = new Item("Item 8", 16.2, 2.4, 4.6);
		itemList1.add(item);
		item = new Item("Item 9", 5.24, 2.4, 3.5);
		itemList1.add(item);
		item = new Item("Item 10", 1.2, 7.4, 4.0);
		itemList1.add(item);
		categoryList = new ArrayList<>();

		category = new Category();
		category.setCategoryName("Category 1");
		category.setItemList(itemList);
		categoryList.add(category);

		category = new Category();
		category.setCategoryName("Category 2");
		category.setItemList(itemList1);
		categoryList.add(category);

	}

	@Test
	public void testAddItemToCart() {
		List<CartItem> expectedItems = new ArrayList<>();
		cartItem = new CartItem("Item 2", 12.2, 3.0, 4.8, "Category 1");
		expectedItems.add(cartItem);
		cartItem = new CartItem("Item 7", 10.2, 3.0, 4.8, "Category 2");
		expectedItems.add(cartItem);
		List<CartItem> items = cart.selectItemFromCategory(categoryList);
		assertEquals("Expected items and actual items in cart is same", expectedItems.get(0).getName(),
				items.get(0).getName());
		assertEquals("Expected items and actual items in cart is same", expectedItems.get(1).getName(),
				items.get(1).getName());
	}
	
	@Test 
	public void testAddItemToCartWithMoreItems() {
		List<Category> categories = createCategories();
		List<CartItem> items = cart.selectItemFromCategory(categories);
		double totalCost = 0.0;
		double totalRating = 0.0;
		for(CartItem cartItem: items) {
			totalCost = totalCost + cartItem.getPrice() + cartItem.getShippingCost();
			totalRating = totalRating + cartItem.getRating();
		}
		assertTrue(totalCost > 45 && totalCost <50);
		assertNotNull(items);
		
	}
	private List<Category> createCategories() {

		for (int i = 0; i < 20; i++) {
			Category category = new Category();
			category.setCategoryName("Category " + (i + 1));
			List<Item> itemList = generateItems();
			category.setItemList(itemList);
			this.categoryList.add(category);
		}
		return this.categoryList;
	}

	

	private List<Item> generateItems() {
		List<Item> itemList = new ArrayList<>();
		ShoppingCartUtil util = new ShoppingCartUtil();
		for (int i = 0; i < 10; i++) {

			Item item = new Item("Item"+(i+1) + util.generateRandomInteger(), util.generateRandomDouble(1, 20),
					util.generateRandomDouble(2, 5), util.generateRandomDouble(1, 5));
			itemList.add(item);
			System.out.println(item);
		}
		return itemList;
	}
}
