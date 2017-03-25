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

public class LogIn extends AppCompatActivity implements View.OnClickListener{
    private TextView emailTv,passwordTv,signUpTv,userTv;
    private EditText emailEt,passwordEt;
    Button btnSignin;
    private ProgressDialog progressdialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        progressdialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            //start the new intent
            Intent intent3= new Intent(getApplicationContext(),FoodList.class);
            startActivity(intent3);
        }


        userTv = (TextView) findViewById(R.id.userTv);
        emailTv = (TextView) findViewById(R.id.emilTv);
        passwordTv = (TextView) findViewById(R.id.passwordTv);

        signUpTv = (TextView) findViewById(R.id.signUptv);
        emailEt = (EditText) findViewById(R.id.emilEt);
        passwordEt = (EditText) findViewById(R.id.passwordEt);
        btnSignin = (Button) findViewById(R.id.signinBtn);
        signUpTv.setOnClickListener(this);
        btnSignin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnSignin)
        {
            userLogIn();
        }
        if(view==signUpTv)
        {
            finish();
            Intent intent= new Intent(LogIn.this,MainActivity.class);
            startActivity(intent);
        }

    }

    private void userLogIn() {
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
       /* progressdialog.setMessage("Please wait some Moment");
        progressdialog.show();*/
        firebaseAuth.signInWithEmailAndPassword( email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressdialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            //start the new intent
                            Intent intent2= new Intent(getApplicationContext(),FoodList.class);
                            startActivity(intent2);
                        }
                    }
                });

    }
}
