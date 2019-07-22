package com.shopping.cart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.shopping.cart.model.CartItem;
import com.shopping.cart.model.Category;
import com.shopping.cart.model.Item;


/**
 * @author Navya Surendran
 *
 */
public class Cart {

	private List<CartItem> shoppingCart = new ArrayList<>();

	private static final int MAX_AMOUNT = 50;
	
	private static final int RATING = 4;
	
	

	/**
	 * @param categoryList
	 * @return
	 * function for purchasing items and add it into cart
	 */
	public List<CartItem> selectItemFromCategory(List<Category> categoryList) {

		for (Category category : categoryList) {

			Optional<Item> item = category.getItemList().stream().max(Comparator.comparing(Item::getRating));

			if (item.isPresent()) {

				CartItem cartItem = new CartItem();
				cartItem.setCategoryName(category.getCategoryName());
				cartItem.setName(item.get().getName());
				cartItem.setPrice(Math.round(item.get().getPrice()));
				cartItem.setRating(Math.round(item.get().getRating()));
				cartItem.setShippingCost(Math.round(item.get().getShippingCost()));

				shoppingCart.add(cartItem);
			}

		}

		List<CartItem> cart = addItemToCart(shoppingCart);
		return cart;
	}

	/**
	 * @param cart
	 * @return
	 * This function will add items into cart until it reach max amount.
	 */
	private List<CartItem> addItemToCart(List<CartItem> cart) {
		double totalCost = 0;
		List<CartItem> shoppingCart = new ArrayList<>();
				
		while (totalCost< MAX_AMOUNT) {
			
			
			CartItem item = pickItemWithBestRating(cart);
			
			
			if(totalCost + item.getPrice() + item.getShippingCost() > MAX_AMOUNT) {
				break;
			}
			if(item != null) {
				cart.remove(item);
				shoppingCart.add(item);
				totalCost = totalCost + item.getPrice() + item.getShippingCost();
			}
			
			
		}
		return shoppingCart;
	}
	
	/**
	 * @param cart
	 * @return
	 * This method will pick best items with respect to rating into basket
	 */
	private CartItem pickItemWithBestRating(List<CartItem> cart) {
		Optional<CartItem> item = cart.stream().max(Comparator.comparing(CartItem::getRating));
		if(item.isPresent()) {
			return item.get();
		}else {
			return null;
		}
	}

	/**
	 * @param shoppingCart
	 * This function will print details of items in cart.
	 */
	public void printCartItems(List<CartItem> shoppingCart) {
		double totalCost = 0.0;
		double totalRating = 0.0;
		if (shoppingCart != null) {
			for (CartItem cartItem : shoppingCart) {
				totalCost = totalCost + cartItem.getPrice() + cartItem.getShippingCost();
				totalRating = totalRating + cartItem.getRating();
				System.out.println(cartItem.getCategoryName() + " : " + cartItem.getName());
			}
			System.out.println("Total Cost: $" + totalCost);
			System.out.println("Total Rating: " + totalRating);
		} else {
			System.out.println("Cart is empty");
		}
	}

}
