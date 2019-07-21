package com.shopping.cart.model;

/**
 * @author Navya Surendran
 *
 */
public class Item {

	private String name;

	private double price;

	private double shippingCost;

	private double rating;

	/**
	 * @param name
	 * @param price
	 * @param shippingCost
	 * @param rating
	 */
	public Item(String name, double price, double shippingCost, double rating) {
		this.name = name;
		this.price = price;
		this.shippingCost = shippingCost;
		this.rating = rating;

	}

	/**
	 * @return String
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

	@Override
    public String toString() {
        return String.format(
                "Item[name='%s', price=%f, shipping cost=%f, rating=%f]",
                name, price, shippingCost, rating);
    }
}
