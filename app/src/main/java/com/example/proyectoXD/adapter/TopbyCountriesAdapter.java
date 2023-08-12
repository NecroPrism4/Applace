package com.example.proyectoXD.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoXD.R;
import com.example.proyectoXD.activityTBCMasInfo;
import com.example.proyectoXD.model.TopbyCountriesModel;

import java.util.List;

public class TopbyCountriesAdapter extends RecyclerView.Adapter<TopbyCountriesAdapter.topcountries> {

    private Context contextoTBC;
    private List<TopbyCountriesModel> topbyCountriesModelList;

    public TopbyCountriesAdapter(Context contextoTBC, List<TopbyCountriesModel> topbyCountriesModelList) {
        this.contextoTBC = contextoTBC;
        this.topbyCountriesModelList = topbyCountriesModelList;
    }

    @NonNull
    @Override
    public topcountries onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(contextoTBC).inflate(R.layout.topcountries_row_items, parent, false);
        return new topcountries(view);
    }

    @Override
    public void onBindViewHolder(@NonNull topcountries holder, @SuppressLint("RecyclerView") final int position) {

        holder.imgVTopPaises.setImageResource(topbyCountriesModelList.get(position).getImageurl());
        holder.TxtNamePais.setText(topbyCountriesModelList.get(position).getTopCountryName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a =new Intent(contextoTBC, activityTBCMasInfo.class);
                a.putExtra("imageprin", topbyCountriesModelList.get(position).getImageurl());
                a.putExtra("countryname", topbyCountriesModelList.get(position).getTopCountryName());
                a.putExtra("countrydesc", topbyCountriesModelList.get(position).getTopCountryDesc());
                a.putExtra("linkmoreinfo", topbyCountriesModelList.get(position).getLinkwhitMoreInfoTopCountry());
                a.putExtra("linkgoogletravel", topbyCountriesModelList.get(position).getLinkGoogleTravel());
                a.putExtra("linkyoutube", topbyCountriesModelList.get(position).getLinkYoutubeTopPais());
                contextoTBC.startActivity(a);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topbyCountriesModelList.size();
    }

    public static class topcountries extends  RecyclerView.ViewHolder{

        ImageView imgVTopPaises;
        TextView TxtNamePais;

        public topcountries(@NonNull View itemView) {
            super(itemView);

            imgVTopPaises = itemView.findViewById(R.id.discountImage);
            TxtNamePais = itemView.findViewById(R.id.txtTopCountName);
        }
    }
}
