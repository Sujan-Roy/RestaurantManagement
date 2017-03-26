package com.example.spuzzal.loginreg.Food;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.spuzzal.loginreg.OrderActivity;
import com.example.spuzzal.loginreg.R;

import java.util.ArrayList;

public class FoodMainActivity extends AppCompatActivity {
    Button btnOrder;
    ListView listView;
    Context context;
    ArrayList proglist;

    public static Integer [] foodImage ={R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,
            R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8};
    public static String [] foodName= {"Special one","Breakfast","Famous of Pk","Bread with Fish"
            ,"Sweet","Birani","Home Potato","Milk Sweet"};
    public static String [] price= {"700 taka","200 taka","850 taka","250 taka","300 taka","150 taka","100 taka","350 taka"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_main);
        listView= (ListView) findViewById(R.id.foodList);
        FoodLstAdapter foodLstAdapter=new FoodLstAdapter(this,foodImage,foodName,price);
        btnOrder = (Button) findViewById(R.id.orderBtn);
        listView.setAdapter(foodLstAdapter);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent= new Intent(FoodMainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }
}
