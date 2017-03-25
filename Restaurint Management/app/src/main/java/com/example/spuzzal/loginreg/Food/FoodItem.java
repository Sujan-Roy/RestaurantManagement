package com.example.spuzzal.loginreg.Food;

/**
 * Created by SP.UZZAL on 3/25/2017.
 */

public class FoodItem {
    private String Food_Name;
    /*private String Food_price;*/

    public FoodItem(String food_Name) {
        Food_Name = food_Name;
       /* Food_price = food_price;*/
    }

    public String getFood_Name() {
        return Food_Name;
    }

    public void setFood_Name(String food_Name) {
        Food_Name = food_Name;
    }

   /* public String getFood_price() {
        return Food_price;
    }

    public void setFood_price(String food_price) {
        Food_price = food_price;
    }*/
}
