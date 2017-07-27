package com.rbc.basket.cost.calculator;

import com.rbc.basket.dto.Basket;
import com.rbc.basket.inventry.BasketItem;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Set;

/**
 * Implements functionality for the basket
 */
public class BasketCostCalculatorImpl implements BasketCostCalculator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rbc.basket.cost.calculator.BasketCostCalculator#getTotalPrice(com.rbc
	 * .basket.dto.Basket)
	 */
	public BigDecimal getTotalPrice(Basket basket) {

		// validate input for processing

		if (basket == null) {
			throw new IllegalArgumentException(" basket can not be null");
		}

		Map<BasketItem, Integer> items = basket.getItems();
		return calculateBasketItemPrice(items);

	}

	/**
	 * 
	 * @param items
	 * @return
	 */
	private BigDecimal calculateBasketItemPrice(final Map<BasketItem, Integer> items) {

		BigDecimal totalPrice = null;

		Set<BasketItem> basketItemset = items.keySet();

		// Sum of (quantity * price) for every item in basket.
		totalPrice = basketItemset.stream().map(
				t -> t.getPrice().multiply(new BigDecimal(items.get(t), new MathContext(2, RoundingMode.HALF_EVEN))))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		return totalPrice;

	}
}
