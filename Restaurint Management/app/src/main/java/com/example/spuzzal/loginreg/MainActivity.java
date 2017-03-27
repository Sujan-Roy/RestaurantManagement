package com.example.spuzzal.loginreg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spuzzal.loginreg.Food.FoodList;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnRegister;
    private TextView tvEmail,tvPassword,tvRegister,signinTv,weTv;
    private EditText emailEt,passwordEt;

    private ProgressDialog progressdialog;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressdialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            /*finish();
            //start the new intent
            Intent intent3= new Intent(getApplicationContext(),FoodList.class);
            startActivity(intent3);*/
        }
         weTv = (TextView) findViewById(R.id.textwe);
        tvEmail = (TextView) findViewById(R.id.emilTv);
        tvPassword = (TextView) findViewById(R.id.passwordTv);
        signinTv = (TextView) findViewById(R.id.signTv);
        tvRegister = (TextView) findViewById(R.id.textRegister);

        emailEt = (EditText) findViewById(R.id.emilEt);
        passwordEt = (EditText) findViewById(R.id.passwordEt);

        btnRegister = (Button) findViewById(R.id.registerBtn);

        btnRegister.setOnClickListener(this);
        signinTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnRegister){
            registerUser();
        }
        if(view==signinTv){
           Intent intent= new Intent(MainActivity.this,LogIn.class);
            startActivity(intent);
        }

    }

    private void registerUser() {
        String email= emailEt.getText().toString().trim();
        String password= passwordEt.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            //email is empty show message
            Toast.makeText(this, "Please enter Correct email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //if empty password
            Toast.makeText(this, "Please Enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressdialog.setMessage("Please wait some Moment");
        progressdialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                           finish();
                            //start the new intent
                            Intent intent3= new Intent(MainActivity.this,FoodMainActivity.class);
                            startActivity(intent3);
                            Toast.makeText(MainActivity.this, "Succesfully Register", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(MainActivity.this, "Sorry!!! Fail to Resister.Please Try again", Toast.LENGTH_SHORT).show();
                        }
                        progressdialog.dismiss();
                    }
                });
    }
}
