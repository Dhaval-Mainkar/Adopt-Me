package com.example.trytry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText musername,mpassword;//create a variable name here that has nothing to do with id of the text/button
    Button login,signup;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//to make statusbar disappear

        musername = findViewById(R.id.username);
        mpassword = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= musername.getText().toString().trim();
                String password= mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(username)){
                    musername.setError("Username is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    musername.setError("Password is required");
                    return;
                }

                //authentication
                fAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(login.this, "logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }
                        else {
                            Toast.makeText(login.this, "error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        //for opening signup page
        signup = (Button) findViewById(R.id.button3);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignup();
            }
        });
    }
    public void opensignup(){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}