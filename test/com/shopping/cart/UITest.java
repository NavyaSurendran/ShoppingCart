package com.shopping.cart;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;

import com.shopping.cart.model.CartItem;
import com.shopping.cart.model.Category;
import com.shopping.cart.model.Item;
import com.shopping.cart.ui.UI;

public class UITest {

	private transient List<Category> categoryList;
	
	private transient UI ui = new UI();
	
	@Before
	public void setupMock() {
		categoryList = createCategories();
	}
	

	@Test
	public void testStartScreen() {
		UI ui = new UI();
		
	}

	@Test
	public void testStoreProductsMenu() {
		ui.startScreen();
	}

	@Test
	public void testMenu() {
		ui.menu();
		
	}

	@Test
	public void testPurchaseItems() {
		List<CartItem> cartItems =ui.purchaseItems();
		double totalCost = 0.0;
		double totalRating = 0.0;
		for(CartItem cartItem: cartItems) {
			totalCost = totalCost + cartItem.getPrice() + cartItem.getShippingCost();
			totalRating = totalRating + cartItem.getRating();
			assertTrue(cartItem.getRating() >4);
		}
		
		System.out.println("No of items "+cartItems.size());
		assertTrue(totalCost > 45 && totalCost <50);
		
		assertNotNull(cartItems);
		
	}

	@Test
	public void testDisplayStoreProducts() {
		ui.displayStoreProducts();
	}
	
	@Test
	public void testShowCart() {
		ui.showCart();
	}
	private List<Category> createCategories() {

		for (int i = 0; i < 20; i++) {
			Category category = new Category();
			category.setCategoryName("Category " + (i + 1));
			List<Item> itemList = generateItems();
			category.setItemList(itemList);
			this.categoryList = new ArrayList<>();
			this.categoryList.add(category);
		}
		return this.categoryList;
	}

	private int generateRandomInteger() {
		Random random = new Random();
		return random.nextInt(10);
	}

	private float generateRandomDouble(int min, int max) {
		float random = (float) ThreadLocalRandom.current().nextDouble(min, max);
		return random;
	}

	private List<Item> generateItems() {
		List<Item> itemList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {

			Item item = new Item("Item"+(i+1) + generateRandomInteger(), generateRandomDouble(1, 20),
					generateRandomDouble(2, 5), generateRandomDouble(1, 5));
			itemList.add(item);
			System.out.println(item);
		}
		return itemList;
	}

	@Test
	public void testCreateCategories() {
		fail("Not yet implemented");
	}

}
