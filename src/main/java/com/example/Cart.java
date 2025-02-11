package com.example;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> cartItems = new ArrayList<>();

    public void addItem(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        cartItems.add(new Item(name));

    }

    public Item removeItem(int index) {
        return cartItems.remove(index);
    }

    public void dropCart() {
        cartItems.clear();
    }

    public void checkOut() {
        System.out.println("All set. Enjoy your produce ponytail guy");
    }

    public void changeQuantity(Item Item, int newQuantity) {
        if (cartItems.contains(Item)) {
            for (int i = 0; i < newQuantity; i++) {
                cartItems.add(Item);
            }
        } else {
            System.out.println("Item not found in cart");
        }
    }

    public ArrayList<Item> getCartItems() {
        return cartItems;
    }

}
