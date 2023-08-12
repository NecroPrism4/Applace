package com.example.proyectoXD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import com.example.proyectoXD.adapter.AllWondersAdapter;
import com.example.proyectoXD.adapter.TopbyCountriesAdapter;
import com.example.proyectoXD.adapter.wondersAdapter;
import com.example.proyectoXD.adapter.RecentlyViewedAdapter;
import com.example.proyectoXD.model.Wonders;
import com.example.proyectoXD.model.TopbyCountriesModel;
import com.example.proyectoXD.model.RecentlyViewed;
import com.example.proyectoXD.model.loginCredentials;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.proyectoXD.R.drawable.*;

public class MainActivity extends AppCompatActivity {

    VideoView VdvVideo;

    RecyclerView discountRecyclerView, wonderRecyclerView, recentlyViewedRecycler, AllWondersRecycler;

    TopbyCountriesAdapter topbyCountriesAdapter;
    List<TopbyCountriesModel> topbyCountriesModelList;

    wondersAdapter wondersAdapter;
    List<Wonders> wondersList;

    AllWondersAdapter allWondersAdapter;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView SeeMoreallWonders;

    Random rand = new Random();
    public TextView MensajeBienv;
    public TextView MensajeAleatorio;
    public ViewFlipper V_flipperImagentitle;
    public ImageView ImgCuenta;
    public CardView CdvbtnCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImgCuenta = findViewById(R.id.imgCuenta);
        CdvbtnCuenta = findViewById(R.id.cdvbtnCuenta);
        if(loginCredentials.getIniciado() == null || loginCredentials.getIniciado() == false)
        {
            ImgCuenta.setImageResource(accounticon);
            //Picasso.with(this).load(loginCredentials.getImagenPerfil()).into(ImgCuenta);
        }else Picasso.with(this).load(loginCredentials.getImagenPerfil()).into(ImgCuenta);


        CdvbtnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogSesión();
            }
        });

        VdvVideo = (VideoView) findViewById(R.id.vdvVideo);
        Uri uriMet = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.topdieslugaresmasbellosdelmundo);
        VdvVideo.setMediaController((new MediaController(this)));
        VdvVideo.setVideoURI(uriMet);
        VdvVideo.requestFocus();

        discountRecyclerView = findViewById(R.id.rcyvTopbyCountries);
        wonderRecyclerView = findViewById(R.id.wonderRecycler);
        SeeMoreallWonders = findViewById(R.id.txtSeemore);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        // carga al recycler de top por pais
        topbyCountriesModelList = new ArrayList<>();
        topbyCountriesModelList.add(new TopbyCountriesModel(topargentina,"Argentina" ,
                "Con sus paisajes, cultura y costumbres te sorprenderá, con sus paisajes, cultura y costumbres te sorprenderá, animo a disfrutar de las sabrosas carnes argentinas, admirar las famosas Cataratas del Iguazú, la cultura y los bellos lugares naturales.\n" +
                        "\n" +
                        "Los argentinos son gente muy cálida, su amabilidad es bien conocida en todo el mundo por lo que a los turistas los reciben con los brazos abiertos. Y sin duda como viajero te llevarás el recuerdo de una agradable estancia.",
                "https://www.costacruceros.com/costa-club/magazine/viaje/que-hacer-argentina.html" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4515404%2C4524133%2C4597339%2C4649665%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561%2C4762570%2C4771573%2C4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F0jgd&dest_state_type=main&dest_src=ts&q=top%20lugares%20de%20nepal&sa=X&ved=2ahUKEwioh9iTvsv3AhV8IkQIHZM_DmsQuL0BegQIDRAv&tcfs=EhQKBy9tLzBqZ2QSCUFyZ2VudGluYQ",
                "https://www.youtube.com/watch?v=bWluezXMbSE&ab_channel=ElViajeroFeliz"));
        topbyCountriesModelList.add(new TopbyCountriesModel(topgrecia,"Grecia",
                "Cientos de islas paradisiacas salpicadas de pueblos pintorescos, bosques y montañas en el interior, una gran metrópolis como Atenas, espectaculares restos arquitectónicos de la que fue la civilización más avanzada del mundo.\n" +
                        "Cientos de islas paradisiacas salpicadas de pueblos pintorescos, bosques y montañas en el interior, una gran metrópolis como Atenas, espectaculares restos arquitectónicos de la que fue la civilización más avanzada del mundo.\n" +
                        "Grecia es un destino tanto para los que buscan sol y playa como para los que buscan cultura.",
                "https://www.cervantesvirtual.com/portales/antigua_historia_y_arqueologia/grecia/" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548,2503771,2503781,4258168,4270442,4284970,4291517,4306835,4515404,4524133,4597339,4649665,4722900,4723331,4733969,4738606,4757164,4758493,4762561,4762570,4771573,4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=/m/0chghy&dest_state_type=main&dest_src=o&sa=X&ved=2ahUKEwjilobctMz3AhVsJEQIHVrpDpkQ6tEBKAR6BAgwEAs",
                "https://www.youtube.com/watch?v=UfwI7iCsSzA&ab_channel=Enrique%C3%81lex"));
        topbyCountriesModelList.add(new TopbyCountriesModel(topaustralia,"Australia",
                "Australia es un país joven y eso se deja ver en la arquitectura de sus ciudades y el carácter de sus habitantes, alegre y festivo. Sídney y su famosa ópera son el reflejo de una sociedad dinámica que mira a occidente sin perder su propia esencia. \n" +
                        "El sambenito de país con los animales más mortíferos no tiene que ser un impedimento para los trotamundos que quieran explorar sus tierras y ciudades y perderse en la inmensidad de su horizonte.",
                "https://www.youtooproject.com/australia/" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4515404%2C4524133%2C4597339%2C4649665%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561%2C4762570%2C4771573%2C4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F035qy&dest_state_type=main&dest_src=o&sa=X&ved=2ahUKEwjilobctMz3AhVsJEQIHVrpDpkQ6tEBKAR6BAgwEAs&tcfs=EhIKCC9tLzAzNXF5EgZHcmVjaWE",
                "https://www.youtube.com/watch?v=vJKeZ-YZtrc&ab_channel=ElViajeroFeliz"));
        topbyCountriesModelList.add(new TopbyCountriesModel(topindia,"India",
                "India es un país único debido a su cultura y tradiciones incomparables que es la razón por la India es uno de los destinos turísticos emergentes. Una razón más por eso es por lo que India ahora ofrece la visa por llegada para más de cien países. Usted puede chequear su estado a www.indianvisaonline.gov.in. Para la norte, usted puede encontrar las Himalayas, Al sur Playas y al oeste Desierto y al este es Tribal. Chequee aquí las razones principales para visitar este país asombroso.",
                "https://viajohoy.com/asia/india/porque-deberias-viajar-a-la-india.html" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4515404%2C4524133%2C4597339%2C4649665%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561%2C4762570%2C4771573%2C4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F03rk0&dest_state_type=main&dest_src=o&sa=X&ved=2ahUKEwjilobctMz3AhVsJEQIHVrpDpkQ6tEBKAR6BAgwEAs&tcfs=EhEKCC9tLzAzcmswEgVJbmRpYQ",
                "https://www.youtube.com/watch?v=Ldg-_oo3z8g&ab_channel=WelcometoelMundo"));
        topbyCountriesModelList.add(new TopbyCountriesModel(topindonesia,"Indonesia",
                "Hay muchos turistas que deciden ir a Indonesia por su belleza y diversidad. Conocida por muchos como la bella Indonesia, tiene el segundo bosque tropical más grande, muchas playas vírgenes con lugares perfectos para hacer buceo y olas para surfear, espectaculares senderos hacia volcanes activos y vida salvaje.\n" +
                        "\n" +
                        "Siendo un país tan grande con tanta diversidad de cultura y cubriendo tantos husos horarios distintos, uno puede encontrarse desde misteriosos ritos balineses hasta dragones de Komodo. Indonesia en general es bastante desconocida para los viajeros, con la excepción de Bali, y todavía carece de algunas infraestructuras y el desarrollo es lento pero los mochileros pueden disfrutar la emoción de explorar caminos nuevos y los que buscan en Indonesia un destino de lujo también tienen muchas opciones.\n",
                "https://www.olaviajes.com/india/las-10-razones-principales-para-visitar-india.html" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4515404%2C4524133%2C4597339%2C4649665%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561%2C4762570%2C4771573%2C4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F03ryn&dest_state_type=main&dest_src=o&sa=X&ved=2ahUKEwjilobctMz3AhVsJEQIHVrpDpkQ6tEBKAR6BAgwEAs&tcfs=EhUKCC9tLzAzcnluEglJbmRvbmVzaWE",
                "https://www.youtube.com/watch?v=i8vy-DLwHNw&ab_channel=ElViajeroFeliz"));
        topbyCountriesModelList.add(new TopbyCountriesModel(topitalia,"Italia",
                "Italia goza de un gran patrimonio histórico construido a lo largo de los siglos: los griegos de Sicilia, los etruscos de la Toscana, los romanos del Latium (Lacio), los bizantinos de Palermo, los normandos de la Italia meridional, los artistas del Renacimiento, los palacios barrocos... E incluso la arquitectura contemporánea. El país atrae principalmente a los amamantes del turismo cultural. Florencia es un buen ejemplo de ello. Florencia, la cuna del Renacimiento, rebosa de maravillas que visitar: Santa María del Fiore, el campanario de Giotto, el Pallazo Vecchio, la galería de los Uffizi y el Ponte Vecchio son algunas de las más destacadas.",
                "https://www.lonelyplanet.es/europa/italia" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4515404%2C4524133%2C4597339%2C4649665%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561%2C4762570%2C4771573%2C4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F03rjj&dest_state_type=main&dest_src=o&sa=X&ved=2ahUKEwjilobctMz3AhVsJEQIHVrpDpkQ6tEBKAR6BAgwEAs&tcfs=EhIKCC9tLzAzcmpqEgZJdGFsaWE",
                "https://www.youtube.com/watch?v=VgMyQYzfQhQ&ab_channel=MundoXDescubrir-RaulyDiana"));
        topbyCountriesModelList.add(new TopbyCountriesModel(topjapon,"Japón",
                "Dormir en un ryokan, relajarse en un onsen, contemplar el monte Fuji , ensimismarse con las luces de Tokio , recorrer los templos de Kioto , descender las pistas de esquí de Hokkaido , aventurarse a descubrir el silencio y la paz de la naturaleza japonesa mientras hacemos el Kumano Kodo o degustar la variada gastronomía local del país con más estrellas Michelin del mundo son solo algunas de las maravillosas experiencias que ** Japón ** puede ofrecerte.",
                "https://www.japan.travel/es/es/" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4515404%2C4524133%2C4597339%2C4649665%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561%2C4762570%2C4771573%2C4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F03_3d&dest_state_type=main&dest_src=o&sa=X&ved=2ahUKEwjilobctMz3AhVsJEQIHVrpDpkQ6tEBKAR6BAgwEAs&tcfs=EhIKCC9tLzAzXzNkEgZKYXDDs24",
                "https://www.youtube.com/watch?v=BX_xjseA54I&ab_channel=ElViajeroFeliz"));
        topbyCountriesModelList.add(new TopbyCountriesModel(topnepal,"Nepal",
                "Nepal es un país injustamente olvidado por los viajeros. Al ser tan pequeño y ubicarse entre dos gigantes, India y China, es fácil que a uno le pase por alto ese país de forma estrecha y alargada en medio del Himalaya. Nepal es ante todo el país del Himalaya, la cordillera de montañas más altas del mundo. Ocho de los catorce picos por encima de los ocho mil metros se encuentran en Nepal.\n" +
                        "Nepal es un país para los amantes de la naturaleza y las montañas, pero también para quienes disfruten en una ciudad asiática dirigida por un caos ordenado, para quienes estén interesados en el budismo mahayana o hinduismo, o para quienes busquen aventura en países poco turísticos. Vamos a ver motivos por los que creemos que debéis empezar a pensar seriamente en un viaje a Nepal.",
                "https://www.lonelyplanet.es/asia/nepal" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4515404%2C4524133%2C4597339%2C4649665%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561%2C4762570%2C4771573%2C4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F016zwt&dest_state_type=main&dest_src=o&sa=X&ved=2ahUKEwjilobctMz3AhVsJEQIHVrpDpkQ6tEBKAR6BAgwEAs&tcfs=EhIKCS9tLzAxNnp3dBIFTmVwYWw",
                "https://www.youtube.com/watch?v=5R7-qNE2nsQ&ab_channel=alanxelmundo"));
        topbyCountriesModelList.add(new TopbyCountriesModel(topsuiza,"Suiza",
                "Toda la superficie del país está recubierta de ríos, valles, prados y montañas, pero es al sur donde se dirigen los amantes de las cimas altas pues allí abundan los picos de más de 4.000 metros. Estos enormes picos están siempre cubiertos de nieve, y los aficionados se entretienen a identificarlos con sus impronunciables nombres. Ofrecen unas vistas sobrecogedoras, aunque no se tenga idea de cómo se llaman. En lugares como Saas Fee se pueden admirar hasta catorce de estos gigantes sin ni siquiera salir del pueblo.",
                "https://www.myswitzerland.com/es/" ,
                "https://www.google.com/travel/things-to-do?g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4515404%2C4524133%2C4597339%2C4649665%2C4722900%2C4723331%2C4733969%2C4738606%2C4757164%2C4758493%2C4762561%2C4762570%2C4771573%2C4771758&hl=es-419&gl=mx&cs=1&ssta=1&dest_mid=%2Fm%2F06mzp&dest_state_type=main&dest_src=o&sa=X&ved=2ahUKEwjilobctMz3AhVsJEQIHVrpDpkQ6tEBKAR6BAgwEAs&tcfs=EhEKCC9tLzA2bXpwEgVTdWl6YQ",
                "https://www.youtube.com/watch?v=vpbXcSlPeR8&ab_channel=PlanetaTierra"));

        // carga al recycler en maravillas
        wondersList = new ArrayList<>();
        wondersList.add(new Wonders(1, chichenitza, "Chichén Itzá"));
        wondersList.add(new Wonders(2, ciudadpetra, "Petra"));
        wondersList.add(new Wonders(3, coliseoromano, "Coliseo de Roma"));
        wondersList.add(new Wonders(4, cristoredentor, "Cristo Redentor"));
        wondersList.add(new Wonders(5, machupichu, "Machu Picchu"));
        wondersList.add(new Wonders(6, murallachina, "Muralla China"));
        wondersList.add(new Wonders(7, tajmahal, "Taj Mahal"));

        // añadir informacion al modelo all maravillas
        SeeMoreallWonders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });

        // añadir informacion al modelo RECIENTES
       recentlyViewedList = new ArrayList<>();
       recentlyViewedList.add(new RecentlyViewed("NEPAL", "Es de los mejores países donde hacer senderismo. Nepal alberga una gran extensión de las montañas del Himalaya, entre ellos la montaña más alta y más conocida por todo el mundo, el Monte Everest.",
               "Con toda seguridad, más de una vez te habrán recomendado viajar allí, asegurando que va a ser el viaje de tu vida y que va a costarte enormemente regresar. \nRazones no faltan  para lanzarnos a ese viaje, pero que en realidad se nos pueden quedar algo vacías, puede que no nos digan demasiado.",
               "DURBAR SQUARE\n" +
                       "Es una de las tres plazas Durbar en el valle de Katmandú, en Nepal, clasificadas como Patrimonio de la Humanidad de la Unesco.La plaza Durbar estuvo rodeada con una arquitectura espectacular y claramente muestra las habilidades de los artistas y artesanos Newar a lo largo de varios siglos. \n" +
                       "\n" +
                       "EVEREST BASE CAMP\n" +
                       "El campamento base sur se encuentra en Nepal a una altitud de 5,364 metros y el campamento base norte en el Tíbet a 5,150 metros. Son zonas de acampada rudimentarias situadas en las laderas del Monte Everest que son utilizadas por los escaladores durante su ascensión y posterior descenso. \n" +
                       "\n" +
                       "BOUDHANATH STUPA\n" +
                       "Boudhanath es uno de los lugares sagrados budistas en Katmandú, Nepal. También se conoce como Khāsti en idioma nepal bhasa y como Bauddha o Bodh Nath por los hablantes modernos de Nepal.\n" +
                       "Situada a unos 11 kilómetros del centro en la periferia noreste de Katmandú, es una de las mayores estupas esféricas en Nepal, representando el mandala.\n",
               "nepal", card1, b1));
       recentlyViewedList.add(new RecentlyViewed("ARGENTINA", "Con sus paisajes, cultura y costumbres te sorprenderá, con sus paisajes, cultura y costumbres te sorprenderá, animo a disfrutar de las sabrosas carnes argentinas, admirar las famosas Cataratas del Iguazú, la cultura y los bellos lugares naturales.",
               "Los argentinos son gente muy cálida, su amabilidad es bien conocida en todo el mundo por lo que a los turistas los reciben con los brazos abiertos. Y sin duda como viajero te llevarás el recuerdo de una agradable estancia.",
               "PARQUE NACIONAL IGUAZÚ\n" +
                       "La cataratas de Igazú, elegidas como una de las Siete Maravillas Naturales del Mundo, las cataratas conforman un maravilloso paisaje capaz de hacer saltar las lágrimas de sus visitantes con su salvaje magnitud.\n" +
                       "\n" +
                       "CERRO CATEDRAL\n" +
                       "El Cerro Catedral es una montaña ubicada en San Carlos de Bariloche, a 19 kilómetros del centro de la ciudad y a una hora del Aeropuerto Internacional de la ciudad. Esta montaña se encuentra dentro del parque nacional Nahuel Huapi, en Argentina. Es el centro de esquí más desarrollado de Sudamérica.\n" +
                       "\n" +
                       "QUEBRADA DE LAS CONCHAS\n" +
                       "La Quebrada de las Conchas, también conocida como Quebrada de Cafayate, es una reserva natural que se encuentra ubicada dentro de los Valles Calchaquíes, en la provincia de Salta, norte de la República Argentina, muy cercana a la localidad de Cafayate.\n",
               "argentina", card2, b2));
       recentlyViewedList.add(new RecentlyViewed("GRECIA", "Cientos de islas paradisiacas salpicadas de pueblos pintorescos, bosques y montañas en el interior, una gran metrópolis como Atenas, espectaculares restos arquitectónicos de la que fue la civilización más avanzada del mundo.",
               "Cientos de islas paradisiacas salpicadas de pueblos pintorescos, bosques y montañas en el interior, una gran metrópolis como Atenas, espectaculares restos arquitectónicos de la que fue la civilización más avanzada del mundo.\nGrecia es un destino tanto para los que buscan sol y playa como para los que buscan cultura.",
               "ACRÓPOLIS DE ATENAS\n" +
                       "La Acrópolis de Atenas puede considerarse la más representativa de las acrópolis griegas. La acrópolis era, literalmente, la ciudad alta y estaba presente en la mayoría de las ciudades griegas, con una doble función: defensiva y como sede de los principales lugares de culto.\n" +
                       "\n" +
                       "METEORA\n" +
                       "Los Monasterios de Meteora están localizados en la llanura de Tesalia, al norte de Grecia. En concreto, en las proximidades de Kalambaka, que se encuentra en el valle del río Peneo. Están clasificados como Patrimonio de la Humanidad por la Unesco desde el año 1988. \n" +
                       "Son construcciones sobre la cumbre de masas rocosas grises, talladas por la erosión y llamadas Meteora. \n" +
                       "\n" +
                       "PARTENÓN\n" +
                       "El Partenón es un templo consagrado a la protectora de Atenas, Atenea Pártenos, y uno de los principales templos dóricos octóstilos, algo poco frecuente,  de mármol blanco del Pentélico y cubierto con tejas de mármol de Paros,  que se conservan.\n",
               "grecia", card3, b3));
       recentlyViewedList.add(new RecentlyViewed("INDONESIA", "Hay muchos turistas que deciden ir a Indonesia por su belleza y diversidad. Conocida por muchos como la bella Indonesia, tiene el segundo bosque tropical más grande, espectaculares senderos hacia volcanes activos y vida salvaje.",
               "Siendo un país tan grande con tanta diversidad de cultura y cubriendo tantos husos horarios distintos.\nIndonesia en general es bastante desconocida para los viajeros, con la excepción de Bali, por lo que en general hay mucho por descubrir.",
               "ISLAS GILI\n" +
                       "Las islas Gili son un archipiélago de tres pequeñas islas — Gili Trawangan, Gili Meno y Gili Air — situadas en la costa noroeste de Lombok, Indonesia. \n" +
                       "Las islas son un destino común para los turistas que buscan la experiencia de visitar alguna isla remota. \n" +
                       "\n" +
                       "BOROBUDUR\n" +
                       "Borobudur es una estupa budista con silueta piramidiforme relacionada con la tradición Mahāyāna, que está ubicada en la provincia Java Central de Indonesia, cuarenta kilómetros al noroeste de Yogyakarta. \n" +
                       "Es el monumento budista más grande del mundo. \n" +
                       "\n" +
                       "SACRED MONKEY FOREST SANCTUARY\n" +
                       "Bosque de los Monos de Ubud, es el santuario y hábitat natural del macaco balinés de cola larga. \n" +
                       "Se encuentra en Padangtegal Ubud, Bali.\n",
               "indonesia", card4, R.drawable.card1));

        setTopbyCountryRecycler(topbyCountriesModelList);
        setWondersRecycler(wondersList);
        setRecentlyViewedRecycler(recentlyViewedList);

        MensajeAleatorio = findViewById(R.id.mensajeAleatorio);

        int numrand = rand.nextInt(7);
        switch (numrand)
        {
            case 1:
                MensajeAleatorio.setText("“Cuanto más lejos voy, más me acerco a mí mismo” \n– Andrew McCarthy");
                break;
            case 2:
                MensajeAleatorio.setText("“Viajar es la mejor manera de perderse y encontrarse al mismo tiempo” \n-Brenna Smith");
                break;
            case 3:
                MensajeAleatorio.setText("“No sé a dónde voy, pero prometo que no será aburrido” \n– David Bowie");
                break;
            case 4:
                MensajeAleatorio.setText("“Ve el mundo. Es más fantástico que cualquier sueño” \n– Ray Bradbury");
                break;
            case 5:
                MensajeAleatorio.setText("“Si no escalas la montaña, jamás podrás disfrutar del paisaje”\n– Pablo Neruda");
                break;
            case 6:
                MensajeAleatorio.setText("“Viajar es descubrir que todos están equivocados acerca de otros países” \n– Aldous Huxley");
                break;
            case 7:
                MensajeAleatorio.setText("“El mundo es un libro y aquellos que no viajan leen sólo una página” \n– Agustín de Hipona");
                break;
        }
        int[] imagenes = {R.drawable.imagenmenua,R.drawable.imagenmenub,R.drawable.imagenmenuc,R.drawable.imagenmenud,R.drawable.imagenmenue};
        V_flipperImagentitle = findViewById(R.id.v_flipperImagentitle);
        for(int image: imagenes)
        {
            flipperImagen(image);
        }
    }

    private void init() {
        Intent i = new Intent(this, AllWonders.class);
        startActivity(i);
    }

    private void setTopbyCountryRecycler(List<TopbyCountriesModel> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        topbyCountriesAdapter = new TopbyCountriesAdapter(this,dataList);
        discountRecyclerView.setAdapter(topbyCountriesAdapter);
    }

    private void setWondersRecycler(List<Wonders> wondersDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        wonderRecyclerView.setLayoutManager(layoutManager);
        wondersAdapter = new wondersAdapter(this, wondersDataList);
        wonderRecyclerView.setAdapter(wondersAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

    public  void flipperImagen(int numImge)
    {
        ImageView visor = new ImageView(this);
        visor.setBackgroundResource(numImge);
        V_flipperImagentitle.addView(visor);
        V_flipperImagentitle.setFlipInterval(3000);
        V_flipperImagentitle.setAutoStart(true);
        V_flipperImagentitle.setInAnimation(this, android.R.anim.slide_in_left);
        V_flipperImagentitle.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    void showDialogSesión()
    {
        final Dialog dialogSesion = new Dialog(MainActivity.this);
        dialogSesion.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogSesion.setCancelable(true);
        dialogSesion.setContentView(R.layout.dialog_cerrar_sesion);

        final Button BtnVolverNoCerrar = dialogSesion.findViewById(R.id.btnVolverNoCerrar);
        final Button BtnokCerrar = dialogSesion.findViewById(R.id.btnokCerrar);

        BtnVolverNoCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dialogSesion.dismiss();
            }
        });

        BtnokCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogSesion.dismiss();
                loginCredentials.setIniciado(false);
                ImgCuenta.setImageResource(accounticon);
                Intent i=new Intent(MainActivity.this, LoginActividad.class);
                startActivity(i);
            }
        });
        dialogSesion.show();
    }
}
