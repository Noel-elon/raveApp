package com.example.raveapp;

public class items {


  private int id;
    private String itemName;
    private String itemPrice;
    private int itemImage;


    public items(int id, String itemName, String itemPrice, int itemImage) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }
}
