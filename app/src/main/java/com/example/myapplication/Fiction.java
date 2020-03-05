package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fiction extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction);

        final Button btnReturnFiction = findViewById(R.id.btnReturnFiction);

        //Gestion de la listview
        //Création d'un tableau de stockage des données
        ArrayList<String> listeFictions = new ArrayList<String>();


        try  {
            AssetManager assetManager = getAssets();
            InputStreamReader isr = new InputStreamReader(assetManager.open("fiction.txt"));
            BufferedReader data = new BufferedReader(isr); //Load flux files in tmp memory
            String ligne = "";
            while ((ligne = data.readLine()) != null) {
                Log.i("LocDVD", "Ligne = " + ligne);
                listeFictions.add(ligne); //add each row into the arraylist
            }
            data.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //adapter is like the model from the Jtable in swing, its where the data goes
        final ArrayAdapter<String> adapterList = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_single_choice, listeFictions);
        ListView listeFiction = findViewById(R.id.fiction_listview);
        listeFiction.setAdapter(adapterList); //we load ListView
        listeFiction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("cineClub", "Position " + String.valueOf((position)));
                String titre = adapterList.getItem(position);
                Log.i("cineClub", "Titre " + titre);
            }
        });


        btnReturnFiction.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Fiction.this);

                alertDialog.setTitle("Retour");
                alertDialog.setMessage("Voulez vous revenir à la page d'accueil ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Fiction.this, MainActivity.class);
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
