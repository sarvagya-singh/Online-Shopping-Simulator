package com.inventory;
public class Novel extends Book {
    private String genre;

    public Novel(String name, double price, String author, String ISBN, String genre) {
        super(name, price, author, ISBN);
        this.genre = genre;
    }


    public String display() {
        String s= super.display();
       return s + "\nGenre: " + genre;
    }

    // public double getPrice(){
    //     double p=super.getPrice();
    //     return p;

    // }

    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre;
    }
}
