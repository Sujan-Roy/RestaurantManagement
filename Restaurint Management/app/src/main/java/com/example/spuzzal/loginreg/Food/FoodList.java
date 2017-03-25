package com.example.spuzzal.loginreg.Food;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.spuzzal.loginreg.LogIn;
import com.example.spuzzal.loginreg.OrderActivity;
import com.example.spuzzal.loginreg.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import static com.example.spuzzal.loginreg.R.id.logoutBtn;

public class FoodList extends AppCompatActivity implements View.OnClickListener{
   Button orederBtn;
    private List<FoodItem> foodItems= new ArrayList<FoodItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        orederBtn = (Button) findViewById(R.id.orderBtn);
        orederBtn.setOnClickListener(this);
        foodMenu();
        foodListView();
    }



    private void foodMenu() {
        foodItems.add(new FoodItem("Rice per plate 20 taka"));
        foodItems.add(new FoodItem("Braed per one 15 tk "));
        foodItems.add(new FoodItem("Fish per one 60 taka"));
        foodItems.add(new FoodItem("Vegeteble per plate 15 taka"));
        foodItems.add(new FoodItem("Potato Bean per plate 20 taka"));
        foodItems.add(new FoodItem("7 Up each one 16 taka"));
        foodItems.add(new FoodItem("Water each one 13 taka"));
    }
    private void foodListView() {
        ArrayAdapter<FoodItem> adapter= new MyListAdapter();
        ListView list= (ListView) findViewById(R.id.foodlist);
        list.setAdapter(adapter);
    }
    private class MyListAdapter extends ArrayAdapter<FoodItem>{
        public MyListAdapter(){
            super(FoodList.this,R.layout.food_item,foodItems);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemview= convertView;
            if(itemview==null){
                itemview = getLayoutInflater().inflate(R.layout.food_item,parent,false);
            }
            FoodItem food=foodItems.get(position);
            TextView  foodname= (TextView) itemview.findViewById(R.id.foodNameTv);
            foodname.setText(food.getFood_Name());
           /* TextView  foodprice= (TextView) itemview.findViewById(R.id.foodProceTv);
            foodname.setText(food.getFood_price());
*/
            return itemview;
        }
    }

    @Override
    public void onClick(View view) {
        if(view == orederBtn){
            //firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,OrderActivity.class));
        }

    }
}
