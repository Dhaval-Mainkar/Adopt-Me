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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    private List<ModelClass> userlist;
    private SelectListener2 listener;

    public Adapter(List<ModelClass> userlist) {
        this.context=context;
        this.userlist = userlist;
        this.listener=listener;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource = userlist.get(position).getDog1pic();
        String name = userlist.get(position).getTextviewname();
        String breed = userlist.get(position).getTextviewbreed();
        String desc = userlist.get(position).getTextviewdesc();
        String line = userlist.get(position).getTextviewline();

        holder.setData(resource, name, breed, desc, line);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),details.class);
                intent.putExtra("image",userlist.get(position).getDog1pic());
                intent.putExtra("name",userlist.get(position).getTextviewname());
                intent.putExtra("breed",userlist.get(position).getTextviewbreed());
                intent.putExtra("desc",userlist.get(position).getTextviewdesc());
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
        private TextView textViewname;
        private TextView textViewbreed;
        private TextView textViewdesc;
        private TextView textViewline;
        public CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dog1pic = itemView.findViewById(R.id.dog1pic);
            textViewname = itemView.findViewById(R.id.textviewname);
            textViewbreed = itemView.findViewById(R.id.textviewbreed);
            textViewdesc = itemView.findViewById(R.id.textviewdesc);
            textViewline = itemView.findViewById(R.id.textviewline);
            cardview=itemView.findViewById(R.id.maincontainer);
        }

        public void setData(int resource, String name, String breed, String desc, String line) {
            dog1pic.setImageResource(resource);
            textViewname.setText(name);
            textViewbreed.setText(breed);
            textViewdesc.setText(desc);
        }
    }
}
