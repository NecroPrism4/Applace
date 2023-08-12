package com.example.proyectoXD.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoXD.RecientesDetalles;
import com.example.proyectoXD.R;
import com.example.proyectoXD.model.RecentlyViewed;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder> {

    Context context;
    List<RecentlyViewed> recentlyViewedList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewed> recentlyViewedList) {
        this.context = context;
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false);
        return new RecentlyViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.TxtCountryNamePrev.setText(recentlyViewedList.get(position).getName());
        holder.TxtDescription.setText(recentlyViewedList.get(position).getDescription());
        holder.TxtExtDes.setText(recentlyViewedList.get(position).getExtradescription());
        holder.TxtLugarestext.setText(recentlyViewedList.get(position).getLugaresmethod());
        holder.TxtidLug.setText(recentlyViewedList.get(position).getIdmethod());
        holder.bg.setBackgroundResource(recentlyViewedList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, RecientesDetalles.class);
                i.putExtra("name", recentlyViewedList.get(position).getName());
                i.putExtra("desc",recentlyViewedList.get(position).getDescription());
                i.putExtra("extend",recentlyViewedList.get(position).getExtradescription());
                i.putExtra("lugares",recentlyViewedList.get(position).getLugaresmethod());
                i.putExtra("id",recentlyViewedList.get(position).getIdmethod());
                i.putExtra("image", recentlyViewedList.get(position).getBigimageurl());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public  static class RecentlyViewedViewHolder extends RecyclerView.ViewHolder{

        TextView TxtCountryNamePrev, TxtDescription, TxtExtDes, TxtLugarestext, TxtidLug;
        ConstraintLayout bg;

        public RecentlyViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            TxtCountryNamePrev = itemView.findViewById(R.id.txtCountryNamePrev);
            TxtDescription = itemView.findViewById(R.id.txtDescription);
            TxtExtDes = itemView.findViewById(R.id.txtExtDesc);
            TxtLugarestext = itemView.findViewById(R.id.txtLugarestext);
            TxtidLug = itemView.findViewById(R.id.txtidLug);
            bg = itemView.findViewById(R.id.recently_layout);

        }
    }

}
