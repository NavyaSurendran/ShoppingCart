package com.shopping.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.shopping.cart.model.Category;
import com.shopping.cart.model.Item;
import com.shopping.cart.util.ShoppingCartUtil;

/**
 * @author Navya Surendran
 *
 */
/**
 * @author DELL
 *
 */
public class Shop {

	private List<Category> categoryList;
	
	
	/**
	 * 
	 */
	public Shop(List<category> categoryList) {
		this.categoryList = categoryList;
	}
	
	/**
	 * @return List<Category>
	 * This method will create categories and store it in List
	 */
	public List<Category> createCategories() {
		
		for (int i = 0; i < 20; i++) {
			Category category = new Category();
			category.setCategoryName("Category " + (i + 1));
			List<Item> itemList = generateItems();
			category.setItemList(itemList);
			this.categoryList.add(category);
		}
		return this.categoryList;
	}
	
	/**
	 * @return List<Category>
	 */
	public List<Category> getCategoryList(){
		return this.categoryList; 
	}
	/**
	 * This method will print the details of products in store
	 */
	public void displayStoreProducts(){
		for(Category category: categoryList) {
			System.out.println("Category: "+category.getCategoryName());
			for( Item item: category.getItemList()) {
				System.out.println("Item "+item.getName()+" Price: "+item.getPrice()+" Shipping Cost: "+item.getShippingCost()+" Rating "+item.getRating());;
			}
		}
	}
	

	

	/**
	 * @return
	 * This method will generate list of  items.
	 */
	public List<Item> generateItems() {
		List<Item> itemList = new ArrayList<>();
		ShoppingCartUtil util = new ShoppingCartUtil();
		for (int i = 0; i < 10; i++) {

			Item item = new Item("Item"+(i+1) + util.generateRandomInteger(), util.generateRandomDouble(1, 20),
					util.generateRandomDouble(2, 5), util.generateRandomDouble(1, 5));
			itemList.add(item);
			
		}
		return itemList;
	}

}
