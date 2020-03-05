package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Documentaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentaire);

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
