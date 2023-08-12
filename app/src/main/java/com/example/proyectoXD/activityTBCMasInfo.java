package com.example.proyectoXD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class activityTBCMasInfo extends AppCompatActivity {

    TextView TxtCountryNameinDetalles, TxtCountryDescIntopbyCountries;
    ImageButton BtnLinkCountry;
    ImageView ImgPaisTopByCountryDetalles, BtnBack;
    WebView WbvLugaresRecomendados;
    CardView CardviewYoutube;
    ViewFlipper V_flipperImagenDetallesCountry;

    int Image;
    String Countryname,CountryDesc, Linkmoreinfo, Linkgoogleplaces, Linkyoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbcmas_info);

        Intent i = getIntent();
        Image = i.getIntExtra("imageprin", R.drawable.greciaacropolis);
        Countryname = i.getStringExtra("countryname");
        CountryDesc = i.getStringExtra("countrydesc");
        Linkmoreinfo = i.getStringExtra("linkmoreinfo");
        Linkgoogleplaces = i.getStringExtra("linkgoogletravel");
        Linkyoutube = i.getStringExtra("linkyoutube");

        ImgPaisTopByCountryDetalles = findViewById(R.id.imgPaisTopByCountryDetalles);
        TxtCountryNameinDetalles = findViewById(R.id.txtCountryNameinDetalles);
        TxtCountryDescIntopbyCountries = findViewById(R.id.txtCountryDescIntopbyCountries);
        BtnLinkCountry = findViewById(R.id.btnLinkCountry);
        WbvLugaresRecomendados = findViewById(R.id.wbvLugaresRecomendados);
        CardviewYoutube = findViewById(R.id.cardviewYoutube);
        BtnBack = findViewById(R.id.btnBackTopbyCountries);

        ImgPaisTopByCountryDetalles.setImageResource(Image);
        TxtCountryNameinDetalles.setText(Countryname);
        TxtCountryDescIntopbyCountries.setText(CountryDesc);

        BtnLinkCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(Linkmoreinfo);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        WbvLugaresRecomendados.loadUrl(Linkgoogleplaces);
        setupWebView();

        CardviewYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(Linkyoutube);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activityTBCMasInfo.this, MainActivity.class);
                startActivity(i);
            }
        });


        int[] imagenes1 = {R.drawable.nepaldurbar, R.drawable.nepaleverest, R.drawable.nepalboudhanat};
        int[] imagenes2 = {R.drawable.argentinaigazu, R.drawable.argentinacerrocatedral, R.drawable.argentinaqubradalasconchas};
        int[] imagenes3 = {R.drawable.argentinaqubradalasconchas, R.drawable.greciameteora, R.drawable.argentinacerrocatedral};
        int[] imagenes4 = {R.drawable.indonesiaislasgil, R.drawable.indonesiaborobudur, R.drawable.indonesiasacredmonkey};
        int[] imagenes5 = {R.drawable.indonesiaislasgil, R.drawable.indonesiaborobudur, R.drawable.indonesiasacredmonkey};
        int[] imagenes6 = {R.drawable.indonesiaislasgil, R.drawable.indonesiaborobudur, R.drawable.indonesiasacredmonkey};
        int[] imagenes7 = {R.drawable.indonesiaislasgil, R.drawable.indonesiaborobudur, R.drawable.indonesiasacredmonkey};
        int[] imagenes8 = {R.drawable.indonesiaislasgil, R.drawable.indonesiaborobudur, R.drawable.indonesiasacredmonkey};
        int[] imagenes9 = {R.drawable.indonesiaislasgil, R.drawable.indonesiaborobudur, R.drawable.indonesiasacredmonkey};

        V_flipperImagenDetallesCountry = findViewById(R.id.v_flipperImagenDetallesCountry);
        carga(imagenes1, imagenes2, imagenes3, imagenes4, imagenes5, imagenes6, imagenes7, imagenes8, imagenes9);
    }

    @SuppressLint("JavascriptInterface")
    private void setupWebView() {
        WbvLugaresRecomendados.getSettings().setJavaScriptEnabled(true);
        WbvLugaresRecomendados.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                WbvLugaresRecomendados.loadUrl("javascript:MyApp.resize(document.body.getBoundingClientRect().height)");
                super.onPageFinished(view, url);
            }
        });
        WbvLugaresRecomendados.addJavascriptInterface(this, "MyApp");
    }

    public  void flipperImagenDet(int numImge)
    {
        ImageView visor = new ImageView(this);
        visor.setBackgroundResource(numImge);
        V_flipperImagenDetallesCountry.addView(visor);
        V_flipperImagenDetallesCountry.setFlipInterval(3000);
        V_flipperImagenDetallesCountry.setAutoStart(true);
        V_flipperImagenDetallesCountry.setOutAnimation(this, android.R.anim.slide_out_right);
        V_flipperImagenDetallesCountry.setInAnimation(this, android.R.anim.slide_in_left);
    }

    public  void carga(int[] Imagenes1, int[] Imagenes2, int[] Imagenes3, int[] Imagenes4, int[] Imagenes5, int[] Imagenes6, int[] Imagenes7, int[] Imagenes8, int[] Imagenes9)
    {
        switch (Countryname)
        {
            case "Argentina":
                for(int image: Imagenes1)
                {
                    flipperImagenDet(image);
                }
                break;
            case "Grecia":
                for(int image: Imagenes2)
                {
                    flipperImagenDet(image);
                }
            case "Australia":
                for(int image: Imagenes3)
                {
                    flipperImagenDet(image);
                }
                break;
            case "India":
                for(int image: Imagenes4)
                {
                    flipperImagenDet(image);
                }
                break;
            case "Indonesia":
                for(int image: Imagenes5)
                {
                    flipperImagenDet(image);
                }
                break;
            case "Italia":
                for(int image: Imagenes6)
                {
                    flipperImagenDet(image);
                }
                break;
            case "Japón":
                for(int image: Imagenes7)
                {
                    flipperImagenDet(image);
                }
                break;
            case "Nepal":
                for(int image: Imagenes8)
                {
                    flipperImagenDet(image);
                }
                break;
            case "Suiza":
                for(int image: Imagenes9)
                {
                    flipperImagenDet(image);
                }
                break;
        }
    }

    /*@JavascriptInterface
    public void resize(final float height) {
        activityTBCMasInfo.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                WbvLugaresRecomendados.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, (int) (height * getResources().getDisplayMetrics().density)));
            }
        });
    }*/
}