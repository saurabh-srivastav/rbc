/**
 * 
 */
package com.rbc.basket.inventry;

import java.math.BigDecimal;

/**
 * Responsibility of this interface to retrieve name and price of basket items
 * 
 * @author saurabhsrivastav
 *
 */
public interface BasketItem {

	/**
	 * 
	 * @return name of the item. This also acts as the key for now
	 */
	public String getItemName();

	/**
	 * 
	 * @return selling price of the item
	 * 
	 */
	public BigDecimal getPrice();
}
