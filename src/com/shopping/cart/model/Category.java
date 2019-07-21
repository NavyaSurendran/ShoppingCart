package com.shopping.cart.model;

import java.util.List;

public class Category {

	private String categoryName;

	private List<Item> itemList;

	/**
	 * @return String
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return List<Item>
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
