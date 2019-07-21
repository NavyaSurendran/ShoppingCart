package com.shopping.cart.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShoppingCartUtil {

	/**
	 * @return 
	 * Generates random integer
	 */
	public int generateRandomInteger() {
		Random random = new Random();
		return random.nextInt(10);
	}

	/**
	 * @param min
	 * @param max
	 * @return
	 * generates random double with the limits
	 */
	public float generateRandomDouble(int min, int max) {
		float random = (float) ThreadLocalRandom.current().nextDouble(min, max);
		return random;
	}
}
