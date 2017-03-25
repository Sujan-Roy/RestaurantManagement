package com.example.spuzzal.loginreg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEt,contactEt,foodEt,quantityEt,deskEt;
    private Button orderBtn,logoutBtn;
    private TextView welTv;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        firebaseAuth = firebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() ==null){
            finish();
            startActivity(new Intent(this,LogIn.class));
        }
        welTv = (TextView) findViewById(R.id.welText);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        nameEt= (EditText) findViewById(R.id.nameEt);
        contactEt= (EditText) findViewById(R.id.contactEt);
        foodEt= (EditText) findViewById(R.id.foodEt);
        quantityEt= (EditText) findViewById(R.id.quantityEt);
        deskEt = (EditText) findViewById(R.id.deskEt);

        orderBtn = (Button) findViewById(R.id.orderBtn);
        logoutBtn = (Button) findViewById(R.id.logoutBtn);

        orderBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
    }
    private void UserOrder(){
        String name= nameEt.getText().toString().trim();
        String contact=contactEt.getText().toString().trim();
        String food= foodEt.getText().toString().trim();
        String quantity= quantityEt.getText().toString().trim();
        String desk = deskEt.getText().toString().trim();

        Order order= new Order(name,contact,food,quantity,desk);
        FirebaseUser user= firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(order);
        Toast.makeText(this,"Succesfully Order..... please wait some moment",Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onClick(View view) {
        if(view==logoutBtn)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LogIn.class));
            Toast.makeText(this,"Log out Succesfully",Toast.LENGTH_SHORT).show();
        }
        if(view==orderBtn)
            UserOrder();

    }
}
