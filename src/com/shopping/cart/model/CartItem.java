package com.shopping.cart.model;

/**
 * @author Navya Surendran
 *
 */
public class CartItem {

	
	private String name;

	private double price;

	private double shippingCost;

	private double rating;

	private String categoryName;
	
	/**
	 * 
	 */
	public CartItem() {
		
	}
	
	/**
	 * @param name
	 * @param price
	 * @param shippingCost
	 * @param rating
	 * @param categoryName
	 */
	public CartItem(String name, double price, double shippingCost, double rating, String categoryName) {
		this.name = name;
		this.price = price;
		this.shippingCost = shippingCost;
		this.rating = rating;
		this.categoryName = categoryName;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return
	 */
	public double getShippingCost() {
		return shippingCost;
	}

	/**
	 * @param shippingCost
	 */
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	/**
	 * @return
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return
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

}
