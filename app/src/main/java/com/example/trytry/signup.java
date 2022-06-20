package com.example.trytry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class signup extends AppCompatActivity {
    public static final String TAG = "tag";
    EditText mfullname,mpassword,memail,mphone;//create a variable name here that has nothing to do with id of the text/button
    Button msignbtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//to make status bar disappear

        mfullname = findViewById(R.id.fullname);
        mpassword = findViewById(R.id.editTextTextPassword);
        memail = findViewById(R.id.editTextTextEmailAddress);
        mphone = findViewById(R.id.editTextPhone);
        msignbtn = findViewById(R.id.signup);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        msignbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = mfullname.getText().toString().trim();//fullname
                String editTextPhone= mphone.getText().toString().trim();//phone
                String editTextTextEmailAddress = memail.getText().toString().trim();//email
                String  editTextTextPassword = mpassword.getText().toString().trim();//password

                if(TextUtils.isEmpty(fullname)){
                    mfullname.setError("Your name is required");//fullname
                    return;
                }

                if(TextUtils.isEmpty(editTextPhone)){
                    mphone.setError("Phone number is required");//phone
                    return;
                }

                if(TextUtils.isEmpty(editTextTextEmailAddress)){
                    memail.setError("Email is required");//email
                    return;
                }

                if(TextUtils.isEmpty(editTextTextPassword)){
                    mpassword.setError("Password is required");//password
                    return;
                }

                //register user in firebase
                fAuth.createUserWithEmailAndPassword(editTextTextEmailAddress,editTextTextPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup.this, "user created", Toast.LENGTH_SHORT).show();
                            userId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userId);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fullname",fullname);         //this variables are for user display that is shown in firebase
                            user.put("email",editTextTextEmailAddress);
                            user.put("phone",editTextPhone);
                            user.put("password",editTextTextPassword);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG,"onSuccess: user profile is created for" + userId);
                                }
                            });


                            startActivity(new Intent(getApplicationContext(),Home.class));

                        }
                        else {
                            Toast.makeText(signup.this, "error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}