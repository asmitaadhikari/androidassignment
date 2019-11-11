package com.example.presidents;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.PresidentsViewHolder>{

    Context cont;
    List<Presidents> list;

    public Adapter(Context cont, List<Presidents> list) {
        this.cont = cont;
        this.list = list;
    }

    @NonNull
    @Override
    public PresidentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newlayout, parent, false);
        return new PresidentsViewHolder(view, cont, list);
    }

    @Override
    public void onBindViewHolder(@NonNull PresidentsViewHolder holder, int position) {
        Presidents presidents = list.get(position);
        holder.Name.setText(presidents.getName());
        holder.img.setImageResource(presidents.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PresidentsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView img;
        TextView Name;
        Context context;
        List<Presidents> list;

        public PresidentsViewHolder(View itemView, Context context, List<Presidents> mList) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            Name = itemView.findViewById(R.id.txtName);
            itemView.setOnClickListener(this);
            this.context = context;
            this.list = mList;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, SecondActivity.class);
            Presidents pres;
            pres = list.get(getAdapterPosition());
            intent.putExtra("image", pres.getImage());
            intent.putExtra("name", pres.getName());
            intent.putExtra("detail", pres.getDesc());
            context.startActivity(intent);
        }
    }
}