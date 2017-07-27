/**
 * 
 */
package com.rbc.basket.cost.calculator;

import java.math.BigDecimal;

import com.rbc.basket.dto.Basket;

/**
 * Responsibility of this interface to derive total price of basket of items.
 * 
 * @author saurabhsrivastav
 *
 */
public interface BasketCostCalculator {
	
	 /**
     * Calculates the total price for the basket.
     * @param basket -  basket containing the items 
     * @return Big decimal representation of the total cost price for the basket
     */
	 BigDecimal getTotalPrice( Basket basket);

}
