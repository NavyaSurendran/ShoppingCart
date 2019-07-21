package com.shopping.cart.ui;

import java.util.List;
import java.util.Scanner;

import com.shopping.cart.Cart;
import com.shopping.cart.Shop;
import com.shopping.cart.model.CartItem;
import com.shopping.cart.model.Category;

/**
 * @author Navya Surendran
 *
 */
public class UI {

	private Cart cart;
	private Shop shop;
	private List<Category> categoryList;
	private List<CartItem> shoppingCart;
	private int ch = 0;

	public UI() {

		cart = new Cart();
		shop = new Shop();
	}

	
	public static void main(String... args) {
		UI ui = new UI();
		ui.menu();
	}
	
	/**
	 * This method will load the start screen
	 */
	public void startScreen() {
		System.out.println("1. Display Store Products");
		System.out.println("2. Display Cart");
		System.out.println("0. Exit");
	}

	/**
	 * This method will list the products  menu 
	 */
	public void storeProductsMenu() {
		System.out.println("1. Purchase Items");
		System.out.println("2. Generate Bill");
		System.out.println("0. Exit");
	}

	/**
	 * This method will list the menu.
	 */
	public void menu() {
		do {
			startScreen();
			getUserInput();

			switch (ch) {
			case 1:
				shop.createCategories();
				displayStoreProducts();
				storeProductsMenu();
				getUserInput();
				innerChoice1();
				break;
			case 2:
				showCart();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				    System.out.println("Please enter any number between 0, 1,2");
				break;
			}
		} while (ch != 0);
	}

	/**
	 * This method will list the innerchoice
	 */
	private void innerChoice1() {
		switch (ch) {
		case 1:
			purchaseItems();
			showCart();
			break;
			
		case 2: 
			showCart();
			break;
		default:
			 System.out.println("Please enter any number between 0, 1,2");
			break;
		}
	}

	/**
	 * @return
	 * @throws NumberFormatException
	 * This method will receive input from console
	 */
	private int getUserInput() throws NumberFormatException {
		
		Scanner in = new Scanner(System.in);	
		if (in.hasNextInt()) {
			ch = in.nextInt();
	    } else {
	       ch =4;
	    }
			 		    
		
		return ch;
	}

	/**
	 * This method will display products in store
	 */
	public void displayStoreProducts() {
		shop.displayStoreProducts();
		
	}	

	/**
	 * @return
	 * This method is used to purchase random products from  store
	 */
	public List<CartItem> purchaseItems() {
		this.categoryList = shop.getCategoryList();
		shoppingCart=cart.selectItemFromCategory(categoryList);
		return shoppingCart;
		
	}

	/**
	 * This method is used to display items in cart.
	 */
	public void showCart() {
		cart.printCartItems(shoppingCart);
	}

	

}
