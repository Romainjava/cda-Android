package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Recherche extends AppCompatActivity {
    private EditText edtCherche;
    private Button btnCherche;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        edtCherche = findViewById(R.id.edtCherche);
        btnCherche = findViewById(R.id.btnRecherche);

        btnCherche.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recherche.this, Policier.class);
                intent.putExtra("titre", edtCherche.getText().toString());
                startActivity(intent);
                //setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
