package com.nuvalence.oms.order.model;

public class Order {
    private String sku;
    private int quantity;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "sku='" + sku + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
