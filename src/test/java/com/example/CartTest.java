package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends Assertions {

    @Test
    public void testAddItem() {
        Cart cart = new Cart();
        cart.addItem("apple");
        cart.addItem("banana");
        assertEquals(2, cart.getCartItems().size());
    }

    @Test
    public void testAddNullItem() {
        Cart cart = new Cart();
        assertThrows(NullPointerException.class, () -> cart.addItem(null));
    }

    @Test
    public void testRemoveItem() {
        Cart cart = new Cart();
        cart.addItem("apple");
        Item removed = cart.removeItem(0);
        assertEquals("apple", removed.getName());
        assertEquals(0, cart.getCartItems().size());
    }

    @Test
    public void testRemoveItemInvalidIndex() {
        Cart cart = new Cart();
        cart.addItem("apple");
        assertThrows(IndexOutOfBoundsException.class, () -> cart.removeItem(1));
    }

    @Test
    public void testDropCart() {
        Cart cart = new Cart();
        cart.addItem("apple");
        cart.addItem("banana");
        cart.dropCart();
        assertEquals(0, cart.getCartItems().size());
    }

    @Test
    public void testDropEmptyCart() {
        Cart cart = new Cart();
        cart.dropCart();
        assertEquals(0, cart.getCartItems().size());
    }

    @Test
    public void testChangeQuantity() {
        Cart cart = new Cart();
        cart.addItem("apple");
        Item item = cart.getCartItems().get(0);
        cart.changeQuantity(item, 3);
        assertEquals(4, cart.getCartItems().size());
    }

    @Test
    public void testChangeQuantityNegativeAmount() {
        Cart cart = new Cart();
        cart.addItem("apple");
        Item item = cart.getCartItems().get(0);
        cart.changeQuantity(item, -1);
        assertEquals(1, cart.getCartItems().size());
    }

    @Test
    public void testChangeQuantityItemNotFound() {
        Cart cart = new Cart();
        cart.changeQuantity(new Item("apple"), 3);
        assertEquals(0, cart.getCartItems().size());
    }

    @Test
    public void testRemoveItemFromEmptyCart() {
        Cart cart = new Cart();
        assertThrows(IndexOutOfBoundsException.class, () -> cart.removeItem(0));
    }

    @Test
    public void testGetCartItemsEmpty() {
        Cart cart = new Cart();
        assertTrue(cart.getCartItems().isEmpty());
    }
}
