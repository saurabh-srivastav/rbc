package com.rbc.basket.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rbc.basket.inventry.BasketItem;
import com.rbc.basket.inventry.BasketItemImpl;

public class BasketTest {

	private Basket basket;

	@Before
	public void setUp() throws Exception {
		basket = new Basket();
	}

	@Test(expected = IllegalArgumentException.class)
	public void addNullItem() {
		basket.addItem(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addItemWithEmptyName() {
		BasketItem item = new BasketItemImpl("", 0.60);
		basket.addItem(item);

	}

	@Test
	public void clearsAllItemsFromTheBasket() {
		BasketItem item = new BasketItemImpl("Apple", 0.60);
		basket.addItem(item);
		assertTrue(basket.getItems().size() > 0);
		basket.clear();
		assertEquals("Basket must be empty", 0, basket.getItems().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void addItemWithNameAsBlankSpace() {
		BasketItem item = new BasketItemImpl(" ", 0.60);
		basket.addItem(item);
	}

	@Test
	public void addOneItem() {
		BasketItem item = new BasketItemImpl("Apple", 0.60);
		basket.addItem(item);

		assertEquals("Should have 1 item", 1, basket.getItems().size());
	}

	@Test
	public void add2DifferentItems() {
		BasketItem item1 = new BasketItemImpl("Apple", 0.60);
		BasketItem item2 = new BasketItemImpl("banana", 0.40);
		basket.addItem(item1);
		basket.addItem(item2);

		assertEquals("Should have 1 item", 2, basket.getItems().size());
	}

	@Test
	public void add2ItemsOfSameType() {
		BasketItem item1 = new BasketItemImpl("Apple", 0.60);
		BasketItem item2 = new BasketItemImpl("Apple", 0.60);
		basket.addItem(item1);
		basket.addItem(item2);

		assertEquals("Should have 1 item with qty as 2", 1, basket.getItems().size());
		assertEquals("Should have 1 item with qty as 2", new Integer(2), basket.getItems().get(item1));
	}
}
