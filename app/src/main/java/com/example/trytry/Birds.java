package com.example.trytry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Birds extends AppCompatActivity{
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass4> userlist;
    Adapter4 adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initData();
        initRecyclerView();

    }

    private void initData() {
        userlist=new ArrayList<>();
        userlist.add(new ModelClass4(R.drawable.red_macaw_201843, "Jake","Macaw","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass4(R.drawable.a931d5861caf2d6cdf698d76836414bb, "Ravi","Indian","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass4(R.drawable.grayscale, "Melon","Grayscale","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass4(R.drawable.chipping_sparrow_in_song_by_debbie_oppermann__1_, "Cillian","Chipping Sparrow","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass4(R.drawable.cacatua_galerita_width_1600_059b550, "Sheldon","Cacatva Galerita","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass4(R.drawable.alvaro_reyes_uj_8bmrq_ss_unsplash, "Chris Pratt","Alvaro Reyes","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass4(R.drawable.sindh, "Roxy","Sindh Sparrow","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerview4);
        layoutManager=new LinearLayoutManager( this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter4(userlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}