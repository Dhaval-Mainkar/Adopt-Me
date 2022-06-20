package com.example.trytry;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter4 extends RecyclerView.Adapter<Adapter4.ViewHolder> {
    Context context;
    private List<ModelClass4> userlist;
    private SelectListener listener;

    public Adapter4(List<ModelClass4> userlist) {
        this.context = context;
        this.userlist = userlist;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design4, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter4.ViewHolder holder, int p) {
        int resource = userlist.get(p).getbird1pic();
        String name = userlist.get(p).getTextviewname();
        String breed = userlist.get(p).getTextviewbreed();
        String desc = userlist.get(p).getTextviewdesc();
        String line = userlist.get(p).getTextviewline();
        holder.setData(resource, name, breed, desc, line);

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),details.class);
                intent.putExtra("image",userlist.get(p).getbird1pic());
                intent.putExtra("name",userlist.get(p).getTextviewname());
                intent.putExtra("breed",userlist.get(p).getTextviewbreed());
                intent.putExtra("desc",userlist.get(p).getTextviewdesc());
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView dog1pic;
        private TextView textname;
        private TextView textbreed;
        private TextView textdesc;
        private TextView textline;
        public CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            dog1pic=itemView.findViewById(R.id.bird1pic);
            textname=itemView.findViewById(R.id.textname);
            textbreed=itemView.findViewById(R.id.textbreed);
            textdesc=itemView.findViewById(R.id.textdesc);
            textline=itemView.findViewById(R.id.textline);
            cardview=itemView.findViewById(R.id.maincontainer);

        }

        public void setData(int resource, String name, String breed, String desc, String line) {
            dog1pic.setImageResource(resource);
            textname.setText(name);
            textbreed.setText(breed);
            textdesc.setText(desc);

        }
    }
}

