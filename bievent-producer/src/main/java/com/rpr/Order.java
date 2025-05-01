package com.rpr;

public class Order {
    private int orderId;
    private String orderItem;
    private double price;
    private int quantity;

    public Order(){}

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderItem = builder.orderItem;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderItem='" + orderItem + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static class Builder{
        private int orderId;
        private String orderItem;
        private double price;
        private int quantity;

        public Builder orderId(int orderId){
            this.orderId = orderId;
            return this;
        }
        public Builder orderItem(String orderItem){
            this.orderItem = orderItem;
            return this;
        }
        public Builder price(double price){
            this.price = price;
            return this;
        }
        public Builder quantity (int quantity){
            this.quantity = quantity;
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }

}
