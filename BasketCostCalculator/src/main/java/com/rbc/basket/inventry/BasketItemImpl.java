package com.rbc.basket.inventry;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Responsibility of this class to validate given basket item and decorate them to process
 */
public class BasketItemImpl implements BasketItem {
	private String itemName;
	private BigDecimal itemPrice;

	public BasketItemImpl(String itemName, Double itemPrice) {
		if (itemName == null || itemName.trim().isEmpty()) {
			throw new IllegalArgumentException("Item name can not be null or empty");
		}
		if (itemPrice == null || itemPrice < 0.0) {
			throw new IllegalArgumentException("Item price can not be null or less than 0.0");
		}

		this.itemName = itemName.toUpperCase();
		this.itemPrice = new BigDecimal(itemPrice, new MathContext(2, RoundingMode.HALF_EVEN));

	}

	/*
	 * (non-Javadoc)
	 * @see com.rbc.basket.inventry.BasketItem#getName()
	 */
	@Override
	public String getItemName() {
		return this.itemName;
	}

	/*
	 * (non-Javadoc)
	 * @see com.rbc.basket.inventry.BasketItem#getPrice()
	 */
	@Override
	public BigDecimal getPrice() {
		return this.itemPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BasketItemImpl basketItemImpl = (BasketItemImpl) o;
		return itemName.equals(basketItemImpl.itemName);
	}

	@Override
	public int hashCode() {
		return itemName.hashCode();
	}
}
