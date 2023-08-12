package com.example.proyectoXD.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoXD.R;
import com.example.proyectoXD.model.Wonders;

import java.util.List;

public class wondersAdapter extends RecyclerView.Adapter<wondersAdapter.WonderViewHolder> {

    private final Context contextoWonders;
    List<Wonders> wondersList;

    public wondersAdapter(Context contextoWonders, List<Wonders> wondersList) {
        this.contextoWonders = contextoWonders;
        this.wondersList = wondersList;
    }

    @NonNull
    @Override
    public WonderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(contextoWonders).inflate(R.layout.wonders_row_items, parent, false);
        return new WonderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WonderViewHolder holder, int position) {
        holder.wondImage.setImageResource(wondersList.get(position).getImageurl());
        String ale = (wondersList.get(position).getNombreWonderPrin());

        holder.TxtNombreWond.setText(ale);
    }

    @Override
    public int getItemCount() {
        return wondersList.size();
    }

    public static class WonderViewHolder extends RecyclerView.ViewHolder{

        ImageView wondImage;
        TextView TxtNombreWond;

        public WonderViewHolder(@NonNull View itemView) {
            super(itemView);

            wondImage = itemView.findViewById(R.id.imgWondIMAGE);
            TxtNombreWond = itemView.findViewById(R.id.txtTopCountName);
        }
    }
}