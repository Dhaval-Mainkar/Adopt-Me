package com.example.trytry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class cats extends AppCompatActivity{
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass2> userlist;
    Adapter2 adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initData();
        initRecyclerView();

    }

    private void initData() {
        userlist=new ArrayList<>();
        userlist.add(new ModelClass2(R.drawable.persian, "Dexter","Persian","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass2(R.drawable.somali, "Draco","Somali Cat","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass2(R.drawable.british, "Tom","British Shorthair","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass2(R.drawable.bombay, "Mars","Bombay Cat","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass2(R.drawable.havanabrown, "Martin","Havana Brown","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass2(R.drawable.donskoy, "Al Pacino","Donskoy","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass2(R.drawable.showshoe, "Timothée","Showdhoe","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
        userlist.add(new ModelClass2(R.drawable.thai, "Thor","Thai","jasdjgasdguasgdugasduasdkajsbdjkbasd","--------------------------------------------------------------------------------"));
    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerview2);
        layoutManager=new LinearLayoutManager( this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter2(userlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}