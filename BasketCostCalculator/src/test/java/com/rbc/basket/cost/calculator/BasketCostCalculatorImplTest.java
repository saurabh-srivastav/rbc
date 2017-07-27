/**
 * 
 */
package com.rbc.basket.cost.calculator;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.rbc.basket.dto.Basket;
import com.rbc.basket.inventry.BasketItem;
import com.rbc.basket.inventry.BasketItemImpl;

/**
 * @author saurabhsrivastav
 *
 */
public class BasketCostCalculatorImplTest {

	private BasketCostCalculator basketCostCalculator;

	@Before
	public void setUp() throws Exception {
		basketCostCalculator = new BasketCostCalculatorImpl();

	}

	@Test
	public void getTotalPriceWithNoItems() throws Exception {
		Basket basket = new Basket();
		BigDecimal actual = basketCostCalculator.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(0, new MathContext(2, RoundingMode.HALF_EVEN));
		assertTrue("Price should be 0", actual.compareTo(expected) == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getTotalPriceWithNullItems() throws Exception {
		basketCostCalculator.getTotalPrice(null);
	}

	@Test
	public void getTotalPriceWithOneItem() throws Exception {
		Basket basket = new Basket();
		BasketItem item = new BasketItemImpl("Banana", 0.60);
		basket.addItem(item);

		BigDecimal actual = basketCostCalculator.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(0.60, new MathContext(2, RoundingMode.HALF_EVEN));
		assertTrue("Price should be 0.60", actual.compareTo(expected) == 0);
	}

	@Test
	public void getTotalPriceWith1Item3Quanity() throws Exception {
		Basket basket = new Basket();
		String name = "Banana";
		double price = 0.60;
		BasketItem item1 = new BasketItemImpl(name, price);
		BasketItem item2 = new BasketItemImpl(name, price);
		BasketItem item3 = new BasketItemImpl(name, price);
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);

		BigDecimal expected = new BigDecimal(1.80, new MathContext(2, RoundingMode.HALF_EVEN));
		BigDecimal actual = basketCostCalculator.getTotalPrice(basket);

		assertTrue("Price should be 1.80", actual.compareTo(expected) == 0);
	}

	@Test
	public void getTotalPriceWith3ItemQuanity1each() throws Exception {
		Basket basket = new Basket();
		BasketItem item1 = new BasketItemImpl("Banana", 0.60);
		BasketItem item2 = new BasketItemImpl("Apple", 0.50);
		BasketItem item3 = new BasketItemImpl("Orange", 0.40);
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);

		BigDecimal actual = basketCostCalculator.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(1.50, new MathContext(2, RoundingMode.HALF_EVEN));
		// banana -0.60, apple -0.50, orange - 0.40
		assertTrue("Price should be 1.50", actual.compareTo(expected) == 0);

	}

	@Test
	public void getTotalPriceWithMultiItemMultiQuanity() throws Exception {
		Basket basket = new Basket();
		BasketItem item1 = new BasketItemImpl("Banana", 0.60);
		BasketItem item2 = new BasketItemImpl("Apple", 0.50);
		BasketItem item3 = new BasketItemImpl("Orange", 0.40);
		BasketItem item4 = new BasketItemImpl("Banana", 0.60);
		BasketItem item5 = new BasketItemImpl("Orange", 0.40);
		BasketItem item6 = new BasketItemImpl("Orange", 0.40);
		BasketItem item7 = new BasketItemImpl("Peaches", 0.40);
		BasketItem item8 = new BasketItemImpl("Lemons", 0.40);
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);
		basket.addItem(item4);
		basket.addItem(item5);
		basket.addItem(item6);
		basket.addItem(item7);
		basket.addItem(item8);

		BigDecimal actual = basketCostCalculator.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(3.70, new MathContext(2, RoundingMode.HALF_EVEN));
		// banana -0.60, apple -0.50, orange - 0.40

		assertTrue("Price should be 3.70", actual.compareTo(expected) == 0);

	}
}
