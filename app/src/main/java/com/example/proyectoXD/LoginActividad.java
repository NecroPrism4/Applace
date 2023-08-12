package com.example.proyectoXD;

import static com.example.proyectoXD.R.drawable.accounticon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.example.proyectoXD.model.loginCredentials;
import com.squareup.picasso.Picasso;

public class LoginActividad extends AppCompatActivity {

    Button BtnLogin;
    ImageView ImgGoogle;
    ImageView ImgCuenta;

    GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_actividad);
        ImgCuenta = findViewById(R.id.imgCuenta);

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        TextView TxtUsername = findViewById(R.id.txtEditUser);
        TextView TxtPassword = findViewById(R.id.txtEditPassword);

        BtnLogin = findViewById(R.id.btnLogin);
        ImgGoogle = findViewById(R.id.imgGoogle);

        //if(loginCredentials.getIniciado() == true){startActivity(new Intent(LoginActividad.this,MainActivity.class));}

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TxtUsername.getText().toString().equals("admin") && TxtPassword.getText().toString().equals("admin"))
                {
                    //Correcto
                   Toast.makeText(LoginActividad.this, "Iniciando sesión...", Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(LoginActividad.this,MainActivity.class));
                }else Toast.makeText(LoginActividad.this, "Usuario y/o contraseña incorrectos..", Toast.LENGTH_SHORT).show();
                //Incorrecto
            }
        });

        ImgGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //iniciarSesionG();
                signIn();
            }
        });

        Boolean x = loginCredentials.getIniciado();

        if(x == null || x != false)
        {
            //signOut();
        }else signOut();
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(LoginActividad.this, "Sesión cerrada...", Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();
                loginCredentials.setImagenPerfil(personPhoto);
            }
            loginCredentials.setIniciado(true);
            startActivity(new Intent(LoginActividad.this,MainActivity.class));
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("Message: ", e.toString());
        }
    }

    /*void iniciarSesionG()
    {
        Intent signinClient = gSignClient.getSignInIntent();
        startActivityForResult(signinClient, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if(requestCode == 1000){
             Task <GoogleSignInAccount> tarea = GoogleSignIn.getSignedInAccountFromIntent(data);
             try {
                 tarea.getResult(ApiException.class);
                 iniciarMainActivity();
             } catch (ApiException e) {
                 //e.printStackTrace();
                 Toast.makeText(LoginActividad.this, "Algo salió mal...", Toast.LENGTH_SHORT).show();
             }
         }
    }
    void iniciarMainActivity()
    {
        finish();
        Intent intent = new Intent(LoginActividad.this, MainActivity.class);
        startActivity(intent);

    }*/
}