/**
 * 
 */
package com.rbc.basket.inventry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * @author saurabhsrivastav
 *
 */
public class BasketItemImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithNullNameAndPrice() {
        new BasketItemImpl(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithNullNameAndValidPrice() {
         new BasketItemImpl(null,0.10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithValidNameAndNullPrice() {
        new BasketItemImpl("Test",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithEmptyNameAndValidPrice() {
         new BasketItemImpl("",0.10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithBlankSpaceNameAndPrice() {
         new BasketItemImpl(" ",0.10);
    }


    @Test
    public void testEquals() throws Exception {
        BasketItem item1 = new BasketItemImpl("Apple",0.10);
        BasketItem item2 = new BasketItemImpl("Apple",0.10);
        BasketItem item3 = new BasketItemImpl("apple",0.10);

        assertEquals("Items should be equal",item1,item2);
        assertEquals("Items should be equal",item3,item2);
    }

    @Test
    public void testHashCode() throws Exception {
        BasketItem item1 = new BasketItemImpl("Apple",0.10);
        BasketItem item2 = new BasketItemImpl("Apple",0.10);
        BasketItem item3 = new BasketItemImpl("apple",0.10);

        assertEquals("Items should be equal",item1.hashCode(),item2.hashCode());
        assertEquals("Items should be equal",item3.hashCode(),item2.hashCode());
    }

}
