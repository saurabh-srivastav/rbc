package com.rbc.basket.dto;

import java.util.HashMap;

import com.rbc.basket.inventry.BasketItem;

/**
 * Class to manage the Basket items.
 */
public class Basket {

	private HashMap<BasketItem, Integer> items;

	/**
	 * 
	 * @return
	 */
	public HashMap<BasketItem, Integer> getItems() {
		return items;
	}

	/**
	 * 
	 */
	public Basket() {
		items = new HashMap<>();
	}

	/**
	 * 
	 * @param item
	 *            BasketItem to be added
	 */
	public void addItem(BasketItem item) {
		if (item == null) {
			throw new IllegalArgumentException("Basket item can not be null");
		}

		if (items.containsKey(item)) {
			items.replace(item, items.get(item) + 1);
		} else {
			items.put(item, 1);
		}
	}

	/**
	 * Clears all items in the shopping basket
	 */
	public void clear() {
		items.clear();
	}

}
