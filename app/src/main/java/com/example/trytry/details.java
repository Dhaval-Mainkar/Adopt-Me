package com.example.trytry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends AppCompatActivity {
    ImageView img;
    TextView name,breed,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        img=findViewById(R.id.detailpic);
        name=findViewById(R.id.detailname);
        breed=findViewById(R.id.detailbreed);
        desc=findViewById(R.id.detaildesc);

        img.setImageResource(getIntent().getIntExtra("image", 0));
        name.setText(getIntent().getStringExtra("name"));
        breed.setText(getIntent().getStringExtra("breed"));
        desc.setText(getIntent().getStringExtra("desc"));
    }
}