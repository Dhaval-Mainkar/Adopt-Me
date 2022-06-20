package com.example.trytry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class dog extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userlist;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initData();
        initRecyclerView();
    }

    private void initData() {
        userlist=new ArrayList<>();
        userlist.add(new ModelClass(R.drawable.golden, "Bolt","Golden Retrieve","ubuhbjhnkmlkmkjygcdzsxgh kmijhycdzsdz","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass(R.drawable.rottweiler, "Biscuit","Rottwiler","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass(R.drawable.beagle, "Oliver","Beagle","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass(R.drawable.lab, "Bruno","labrador","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass(R.drawable.bulldog, "Cooper","Bulldog","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass(R.drawable.husky, "Barry","Husky","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass(R.drawable.german, "Coco","German Shepherd","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass(R.drawable.chow, "Jake","Chow Chow","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass(R.drawable.shitzu, "Jackson","Shi Tzu","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));

    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager( this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}