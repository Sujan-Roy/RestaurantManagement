package com.example.spuzzal.loginreg;

/**
 * Created by SP.UZZAL on 3/25/2017.
 */

public class Order {
    public String name;
    public String contact;
    public String food;
    public String quantity;
    public  String desk;
    public Order(){

    }

    public Order(String desk, String name, String food, String contact, String quantity) {
        this.desk = desk;
        this.name = name;
        this.food = food;
        this.contact = contact;
        this.quantity = quantity;
    }
}
