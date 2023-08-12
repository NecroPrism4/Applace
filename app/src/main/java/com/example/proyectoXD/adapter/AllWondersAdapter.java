package com.example.proyectoXD.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoXD.AllWonders;
import com.example.proyectoXD.MainActivity;
import com.example.proyectoXD.R;
import com.example.proyectoXD.model.AllWondersModel;


import java.util.List;

public class AllWondersAdapter extends RecyclerView.Adapter<AllWondersAdapter.ViewHolder> {

    private List<AllWondersModel> WonderList;
    private final LayoutInflater lInflator;
    private final Context context;

    public AllWondersAdapter(List<AllWondersModel> wonderList, Context context) {
        this.lInflator = LayoutInflater.from(context);
        this.context = context;
        this.WonderList = wonderList;
    }

    @Override
    public int getItemCount() {
        return WonderList.size();
    }


    @Override
    public AllWondersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = lInflator.inflate(R.layout.all_wonders_row_items, null);
        return new AllWondersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AllWondersAdapter.ViewHolder holder, final int  position)
    {
        holder.bindData(WonderList.get(position));
        holder.btnInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = String.valueOf(holder.TxtLinkMara.getText());
                Uri link = Uri.parse(url);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                context.startActivity(i);
            }
        });
    }

    public void setItems(List<AllWondersModel> items) { WonderList = items;}

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView ImgvMaravilla;
        TextView TxtTitulo,TxtDescWonder, TxtLinkMara;

        ImageButton btnInternet;

        ViewHolder(View itemView)
        {
            super(itemView);
            ImgvMaravilla = itemView.findViewById(R.id.imgWondIMAGE);
            TxtTitulo = itemView.findViewById(R.id.txtWonderName);
            TxtDescWonder = itemView.findViewById(R.id.txtWonderDesc);
            TxtLinkMara =  itemView.findViewById(R.id.txtLinkWonders);

            btnInternet = itemView.findViewById(R.id.btnLinkWonder);
        }
        //events

        void bindData(final AllWondersModel item)
        {
            ImgvMaravilla.setImageResource(item.getImageurl());
            TxtTitulo.setText(item.getNombre());
            TxtDescWonder.setText(item.getDescripcion());
            TxtLinkMara.setText(item.getUrlPagina());
        }
    }
}