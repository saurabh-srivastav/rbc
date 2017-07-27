/**
 * 
 */
package com.rbc.basket.testsuit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rbc.basket.cost.calculator.BasketCostCalculatorImplTest;
import com.rbc.basket.dto.BasketTest;
import com.rbc.basket.inventry.BasketItemImplTest;

/**
 * @author saurabhsrivastav
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BasketCostCalculatorImplTest.class, BasketTest.class,BasketItemImplTest.class})
public class AllTests {

	


}
