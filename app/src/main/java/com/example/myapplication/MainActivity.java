package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnPolicier = findViewById(R.id.btnPolicier);
        final Button btnFiction = findViewById(R.id.btnFiction);
        final Button btnDocumentaire = findViewById(R.id.btnDocu);
        final Button btnSeries = findViewById(R.id.btnSerie);

        btnPolicier.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Policier");
                alertDialog.setMessage("Voulez vous choisir un film Policier ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,Policier.class);
                        startActivity(intent);
                    }
                });
               alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                    //
                   }
               });
               alertDialog.show();
            }
        });

        btnFiction.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Fiction");
                alertDialog.setMessage("Voulez vous choisir une fiction ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,Fiction.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                alertDialog.show();
            }
        });

        btnDocumentaire.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Documentaire");
                alertDialog.setMessage("Voulez vous choisir un Documentaire ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,Documentaire.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                alertDialog.show();
            }
        });

        btnSeries.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Séries");
                alertDialog.setMessage("Voulez vous choisir une Séries ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,Series.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId())
        {
            case R.id.menuRechercher :
                this.intent = new Intent(MainActivity.this, Recherche.class);
                startActivityForResult(intent,2);
               return true;

            case R.id.menuReserver :
                this.intent = new Intent(MainActivity.this, Reservation.class);
                startActivityForResult(intent,1);
                return true;

            case R.id.menuMagasin:

                return true;

            case R.id.menuPrésentation:
                //lol
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        switch (requestCode){
            case 1 :
                switch (resultCode){
                    case RESULT_OK:
                        Toast.makeText(MainActivity.this,
                                "Reservation confirmée",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_CANCELED:
                        Toast.makeText(MainActivity.this,
                                "Reservation annulée",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case 2 :
                switch (resultCode){
                    case RESULT_OK:
                        String titre = data.getStringExtra("titre");
                        Toast.makeText(MainActivity.this,
                                titre,
                                Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return;
    }
}
