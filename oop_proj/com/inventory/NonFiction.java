package com.inventory;
public class NonFiction extends Book {
    private String topic;

    public NonFiction(String name, double price, String author, String ISBN, String topic) {
        super(name, price, author, ISBN);
        this.topic = topic;
    }

    public String display() {
        String s= super.display();
        return s + "\nTopic: " + topic;
    }

    // public double getPrice(){
    //     double p=super.getPrice();
    //     return p;

    // }

    @Override
    public String toString() {
        return super.toString() + "\nTopic: " + topic;
    }
}
