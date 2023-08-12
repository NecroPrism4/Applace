package com.example.proyectoXD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.proyectoXD.adapter.AllWondersAdapter;
import com.example.proyectoXD.model.AllWondersModel;

import java.util.ArrayList;
import java.util.List;

public class AllWonders extends AppCompatActivity {

    List<AllWondersModel> allWondersModelList;

    ImageView back;
    ImageButton internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_wonders);
        internet = findViewById(R.id.btnLinkWonder);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(AllWonders.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        allWondersModelList = new ArrayList<>();
        allWondersModelList.add(new AllWondersModel(1, R.drawable.chichenitza, "Chichén Itzá",
                "La legendaria ciudad maya de Chichén Itzá, Patrimonio de la Humanidad declarada por la UNESCO desde 1988 y Maravilla del Mundo desde 2007, sobresalió como centro cultural y político de la vieja civilización maya y fue uno de los asentamientos más extensos del centro-norte de la península de Yucatán." ,
                "https://www.inah.gob.mx/zonas/146-zona-arqueologica-de-chichen-itza"));
        allWondersModelList.add(new AllWondersModel(2, R.drawable.ciudadpetra, "Petra",
                "En griego, Petra significa “excavada en piedra” y es que, ubicada en un angosto valle, esta ciudad está literalmente tallada en la roca. Petra, o Raqmu, como la llamaban sus segundos pobladores, los nabateos, es uno de esos enclaves que dejan sin palabras cuando se les visita por primera vez." ,
                "http://www.visitpetra.jo/"));
        allWondersModelList.add(new AllWondersModel(3, R.drawable.coliseoromano, "Coliseo de Roma",
                "El Coliseo se convirtió en el mayor anfiteatro romano, con una estructura elíptica de 188 metros de longitud, 156 metros de ancho y 57 metros de altura. Realizado en ladrillo y cubierto con travertino se dividía en cinco niveles con una capacidad para más de 50.000 personas." ,
                "https://www.coopculture.it/it/prodotti/biglietto-colosseo-foro-palatino_24h/"));
        allWondersModelList.add(new AllWondersModel(4, R.drawable.cristoredentor, "Cristo Redentor",
                "El Cristo Redentor es una escultura de estilo Art Déco, con los brazos abiertos en forma de una cruz, de 38 metros de altura, el equivalente a un edificio de 13 pisos. De ese total, 30 metros son equivalentes al monumento y los otros ocho metros equivalen al pedestal." ,
                "https://visit.rio/es/que_fazer/cristo-redentor-2/"));
        allWondersModelList.add(new AllWondersModel(5, R.drawable.machupichu, "Machu Picchu",
                "Esta antigua ciudad inca es uno de los tesoros más preciados de Perú. Fue construida a mediados del siglo XV y se cree que fue una de las residencias del noveno inca del Tahuantinsuyo, Pachacútec, aunque en ella también están los restos de un santuario.",
                "https://www.machupicchu.gob.pe/"));
        allWondersModelList.add(new AllWondersModel(6, R.drawable.murallachina, "La Gran Muralla China",
                "la Gran Muralla China es una antigua fortificación china construida y reconstruida entre el siglo V a.C. y el siglo XVI (Edad Moderna), para proteger la frontera norte del Imperio Chino durante las sucesivas dinastías imperiales de los ataques de los nómadas xiongnu de Mongolia y Manchuria." ,
                "http://www.mutianyugreatwall.com/"));
        allWondersModelList.add(new AllWondersModel(7, R.drawable.tajmahal, "Taj Mahal",
                "El Taj Mahal es un mausoleo construido por el emperador mogol Sha Jahan en honor a su esposa preferida, Mumtaz Mahal (la «Elegida del Palacio» o la «Joya del Palacio»), muerta al dar a luz. Taj Mahal (abreviación del nombre de Mumtaz Mahal) significa también “La Joya del Palacio”." ,
                "https://www.tajmahal.gov.in/"));

        AllWondersAdapter allWondersAdapter = new AllWondersAdapter(allWondersModelList, this);
        RecyclerView Rcyv_all_wonders = findViewById(R.id.rcyv_all_wonders);
        Rcyv_all_wonders.setHasFixedSize(true);
        Rcyv_all_wonders.setLayoutManager(new LinearLayoutManager(this));
        Rcyv_all_wonders.setAdapter(allWondersAdapter);
    }
}


