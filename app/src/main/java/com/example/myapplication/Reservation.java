package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reservation extends AppCompatActivity {
    private Button btnConfirmReservation;
    private Button btnAnnulerReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);



        final Button btnReturnReservation = findViewById(R.id.btnReturnReservation);

        //CONFIRMER EVENT
        btnConfirmReservation = findViewById(R.id.btnConfirmerReservation);
        btnConfirmReservation.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        //ANNULATION EVENT
        btnAnnulerReservation = findViewById(R.id.btnAnnulerReservation);
        btnAnnulerReservation.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });


        //RETOUR EVENT
        btnReturnReservation.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Reservation.this);

                alertDialog.setTitle("Retour");
                alertDialog.setMessage("Voulez vous revenir à la page d'accueil ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Reservation.this, MainActivity.class);
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
