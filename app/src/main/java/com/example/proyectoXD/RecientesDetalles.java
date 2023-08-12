package com.example.proyectoXD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class RecientesDetalles extends AppCompatActivity {

    ImageView img, back;
    TextView countryName, extend, countryDesc, lugares, Id;

    String name, extra, desc, lugar, Idup;
    int image;

    public ViewFlipper V_flipperImagenDet;
    public ImageButton sendInternet;

    public String Link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detalles);

        Intent i = getIntent();

         name = i.getStringExtra("name");
         desc = i.getStringExtra("desc");
         extra = i.getStringExtra("extend");
         lugar = i.getStringExtra("lugares");
         Idup = i.getStringExtra("id");
         image = i.getIntExtra("image", R.drawable.b1);

         countryName = findViewById(R.id.txtWonderName);
         countryDesc = findViewById(R.id.txtWonderDesc);
         extend = findViewById(R.id.txtExtend);
         lugares = findViewById(R.id.txtLugarestext);
         Id = findViewById(R.id.txtidLug);
         img = findViewById(R.id.big_image);
         back = findViewById(R.id.btnBackTopbyCountries);

         countryName.setText(name);
         extend.setText(extra);
         countryDesc.setText(desc);
         lugares.setText(lugar);
         Id.setText(Idup);

        img.setImageResource(image);

        sendInternet = findViewById(R.id.btnLinkWonder);

        sendInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(Link);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecientesDetalles.this, MainActivity.class);
                startActivity(i);
            }
        });

        int[] imagenes1 = {R.drawable.nepaldurbar, R.drawable.nepaleverest, R.drawable.nepalboudhanat};
        int[] imagenes2 = {R.drawable.argentinaigazu, R.drawable.argentinacerrocatedral, R.drawable.argentinaqubradalasconchas};
        int[] imagenes3 = {R.drawable.argentinaqubradalasconchas, R.drawable.greciameteora, R.drawable.argentinacerrocatedral};
        int[] imagenes4 = {R.drawable.indonesiaislasgil, R.drawable.indonesiaborobudur, R.drawable.indonesiasacredmonkey};

        V_flipperImagenDet = findViewById(R.id.v_flipperImagenDet);
        carga(imagenes1, imagenes2, imagenes3, imagenes4);
    }

    public  void flipperImagenDet(int numImge)
    {
        ImageView visor = new ImageView(this);
        visor.setBackgroundResource(numImge);
        V_flipperImagenDet.addView(visor);
        V_flipperImagenDet.setFlipInterval(3000);
        V_flipperImagenDet.setAutoStart(true);
        V_flipperImagenDet.setInAnimation(this, android.R.anim.slide_in_left);
        V_flipperImagenDet.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public  void carga(int[] Imagenes1, int[] Imagenes2, int[] Imagenes3, int[] Imagenes4)
    {
        switch (Idup)
        {
            case "nepal":
                Link = "https://www.google.com/travel/things-to-do?g2lb=2502548,2503771,2503781,4258168,4270442,4284970,4291517,4306835,4524133,4597339,4649665,4680677,4722900,4723331,4733969,4738606,4757164,4758493,4762561&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=/m/016zwt&dest_state_type=main&dest_src=ts&q=nepal+top+lugares&sa=X&ved=2ahUKEwjyxvbK18L3AhUEI0QIHTiBARQQuL0BegQIEhAv";
                for(int image: Imagenes1)
                {
                    flipperImagenDet(image);
                }
                break;
            case "argentina":
                Link = "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4524133%2C4597339%2C4649665%2C4680677%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F0jgd&dest_state_type=main&dest_src=ts&q=nepal%20top%20lugares&sa=X&ved=2ahUKEwjyxvbK18L3AhUEI0QIHTiBARQQuL0BegQIEhAv&tcfs=EhQKBy9tLzBqZ2QSCUFyZ2VudGluYQ";
                for(int image: Imagenes2)
                {
                    flipperImagenDet(image);
                }
                break;
            case "grecia":
                Link = "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4524133%2C4597339%2C4649665%2C4680677%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F035qy&dest_state_type=main&dest_src=ts&q=nepal%20top%20lugares&sa=X&ved=2ahUKEwjyxvbK18L3AhUEI0QIHTiBARQQuL0BegQIEhAv&tcfs=EhIKCC9tLzAzNXF5EgZHcmVjaWE";
                for(int image: Imagenes3)
                {
                    flipperImagenDet(image);
                }
                break;
            case "indonesia":
                Link = "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4524133%2C4597339%2C4649665%2C4680677%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F03ryn&dest_state_type=main&dest_src=ts&q=nepal%20top%20lugares&sa=X&ved=2ahUKEwjyxvbK18L3AhUEI0QIHTiBARQQuL0BegQIEhAv&tcfs=EhUKCC9tLzAzcnluEglJbmRvbmVzaWE";
                for(int image: Imagenes4)
                {
                    flipperImagenDet(image);
                }
                break;
        }
    }
}
