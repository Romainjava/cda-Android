package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Policier extends AppCompatActivity {

    public String filmsPoliciers[] =
            {
                    "Kill bill-Vol1",
                    "Kill bill-Vol2",
                    "Otage",
                    "Da Vinci Code",
                    "36 quai des Orfèvres",
                    "Mystic River"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policier);

        final Button btnReturnPolice = findViewById(R.id.btnReturnPolice);
        final ArrayAdapter<String> adapterList = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_single_choice, filmsPoliciers);

        //RECUPERE LE TITRE CHOISE DE LA LISTVIEW
        ListView listPolicier = (ListView) findViewById(R.id.policier_listview);
        listPolicier.setAdapter(adapterList);

        String str = this.getIntent().getStringExtra("titre");
        TextView titreDemande = findViewById(R.id.titreDemande);

        if (str == null || str.isEmpty()) {
            titreDemande.setText("Aucun titre demandé.");
            //Toast.makeText(Policier.this, "Pas de titre demandé",
            //        Toast.LENGTH_SHORT).show();
        } else {
            titreDemande.setText(str);
        }

        //EVENEMENT SUR LES BOUTONS RADIO
        listPolicier.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("LocDVD", "Position "+ String.valueOf(position));
                String titre = adapterList.getItem(position);
                Log.i("LocDVD", "Titre "+ titre);
                Toast toast = Toast.makeText(getApplicationContext(), "Position : "+
                        String.valueOf(position), Toast.LENGTH_SHORT);
                toast.show();
                Toast toast_two = Toast.makeText(getApplicationContext(), "Titre : "+
                       titre, Toast.LENGTH_SHORT);
                toast_two.show();
            }
        });

        btnReturnPolice.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Policier.this);
                alertDialog.setTitle("Retour");
                alertDialog.setMessage("Voulez vous revenir à la page d'accueil ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Policier.this, MainActivity.class);
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
}
