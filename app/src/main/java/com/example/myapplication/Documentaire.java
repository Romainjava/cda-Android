package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.cineclub.Film;
import data.cineclub.FilmAdapter;

public class Documentaire extends AppCompatActivity {
    private ListView listeDocumentaire;
    private FilmAdapter adapterDoc;


    public String lireLeJSON(){
        StringBuilder builder = new StringBuilder();
        AssetManager assetManager;
        InputStreamReader isr;
        BufferedReader data;

        try {
            assetManager = getAssets();
            isr = new InputStreamReader(assetManager.open("documentaire.json"));
            data = new BufferedReader(isr);
            String line;
            while((line = data.readLine()) != null) {
                builder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString(); //données JSON au format chaîne
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentaire);

        listeDocumentaire = findViewById(R.id.doc_listView);
        Log.i("LocDVD","Vu Documentaire");
        this.adapterDoc = new FilmAdapter(this,R.layout.ligne);

        String strJson = lireLeJSON();

        try {
            JSONArray jsonArray = new JSONArray(strJson);
            //Creation et alimentation d'un tableau JSON avec la chaine de caractère

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Film docu = new Film();

                docu.setStrCat(jsonObject.getString("cat"));
                docu.setStrTitle(jsonObject.getString("titre"));
                docu.setStrRealisateur(jsonObject.getString("realisateur"));

                String path = getPackageName() + ":drawable/" + jsonObject.getString("img");
                int resID = getResources().getIdentifier(path,null,null);

                docu.setImg(resID);
                adapterDoc.add(docu);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        listeDocumentaire.setAdapter(adapterDoc);

        final Button btnReturnDocumentaire = findViewById(R.id.btnReturnDocumentaire);
        btnReturnDocumentaire.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Documentaire.this);

                alertDialog.setTitle("Retour");
                alertDialog.setMessage("Voulez vous revenir à la page d'accueil ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Documentaire.this, MainActivity.class);
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
