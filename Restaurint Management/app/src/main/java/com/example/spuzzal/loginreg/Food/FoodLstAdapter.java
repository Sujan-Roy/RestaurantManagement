package com.example.spuzzal.loginreg.Food;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spuzzal.loginreg.R;

/**
 * Created by SP.UZZAL on 3/26/2017.
 */

public class FoodLstAdapter extends ArrayAdapter<String> {
    private  final Activity context;
    private  final Integer [] foodImage;
    private  final String [] foodName;
    private  final String [] price;

    public FoodLstAdapter(Activity context, Integer[] foodImage, String[] foodName, String[] price) {
        super(context,R.layout.activity_food_list,foodName);
        this.context = context;
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.price = price;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater= context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_food_list,null,true);
        TextView foodNmae= (TextView) rowView.findViewById(R.id.nameTv);
        ImageView foodImge= (ImageView) rowView.findViewById(R.id.imageFood);
        TextView foodPrice = (TextView) rowView.findViewById(R.id.priceTv);

        foodNmae.setText(foodName[position]);

        foodImge.setImageResource(foodImage[position]);
        foodPrice.setText(price[position]);
        return rowView;
    }
}
