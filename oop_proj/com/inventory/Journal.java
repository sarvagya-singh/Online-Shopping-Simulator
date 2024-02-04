package com.inventory;
public class Journal extends Book {
    private int volume;

    public Journal(String name, double price, String author, String ISBN, int volume) {
        super(name, price, author, ISBN);
        this.volume = volume;
    }

    public String display() { // Change the return type to String
        return super.display() + "\nVolume: " + volume;
    }

    // public double getPrice(){
    //     double p=super.getPrice();
    //     return p;

    // }

    @Override
    public String toString() {
        return super.toString() + "\nVolume: " + volume;
    }
}
