package com.inventory;
public class Book {
    private String name;
    private String author;
    private double price;
    private String ISBN;

    public Book(String name, double price, String author, String ISBN) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.ISBN = ISBN;
    }

    public double getPrice(){
        return price;
    }

    public String display() {
        return "Book Name: " + name + "\nAuthor: " + author + "\nPrice: $" + price + "\nISBN: " + ISBN;
    }

    @Override
    public String toString() {
        return "Book Name: " + name + "\nAuthor: " + author + "\nPrice: $" + price + "\nISBN: " + ISBN;
    }
}

