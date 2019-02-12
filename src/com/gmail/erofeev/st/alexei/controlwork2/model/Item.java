package com.gmail.erofeev.st.alexei.controlwork2.model;

import java.util.Objects;


public class Item {
    private String title;
    private String note;
    private int quantity;
    private float price;

    public Item() {
    }

    public Item(String title, String note, int quantity, float price) {
        this.title = title;
        this.note = note;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity &&
                Float.compare(item.price, price) == 0 &&
                Objects.equals(title, item.title) &&
                Objects.equals(note, item.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, note, quantity, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
