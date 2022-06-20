package com.example.trytry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class reptiles extends AppCompatActivity{
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass3> userlist;
    Adapter3 adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reptiles);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initData();
        initRecyclerView();

    }

    private void initData() {
        userlist=new ArrayList<>();
        userlist.add(new ModelClass3(R.drawable.leon, "Leonardo","Greek Tortoise","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass3(R.drawable.__red_footed_tortoise, "Raphael","Redfooted Tortoise","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass3(R.drawable.mike, "Michelangelo","Turtle","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass3(R.drawable.don, "Donatello","Turtle","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass3(R.drawable.came, "Grogu","Chameleon","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView3);
        layoutManager=new LinearLayoutManager( this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter3(userlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}