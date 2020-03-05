package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import org.xmlpull.v1.XmlPullParser;
import data.cineclub.Film;
import data.cineclub.FilmAdapter;

public class Series extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        //recupere la liste de ligne.xml et instancie ma class filmadapter
        ListView listeSeries = findViewById(R.id.serie_listview);
        FilmAdapter adapterFilm = new FilmAdapter(this,R.layout.ligne);

        try {
            XmlPullParser xmlPullParser = getResources().getXml(R.xml.series);
            //while the end of files is not reached
            //getEventType is waiting for the end the tag (balise en français)
            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                //Si balise ouvrante
                if (xmlPullParser.getEventType() == XmlPullParser.START_TAG) {
                    //si la balise est dvd
                    Log.i("LocDVD","ici getname "+ xmlPullParser.getName());
                    if (xmlPullParser.getName().equals("dvd")) {
                        Film movie = new Film();

                        movie.setStrCat(xmlPullParser.getAttributeValue(null,"cat"));
                        movie.setStrRealisateur(xmlPullParser.getAttributeValue(null,"realisateur"));
                        movie.setStrTitle(xmlPullParser.getAttributeValue(null,"titre"));

                        //get the name of img in the directory drawable
                        String path = getPackageName() + ":drawable/" + xmlPullParser.getAttributeValue(null,"img");
                        int resID = getResources().getIdentifier(path, null, null);
                        movie.setImg(resID);
                        Log.i("LocDVD", "Img = " + ":drawable/" + xmlPullParser.getAttributeValue(1));

                        //add the object
                        adapterFilm.add(movie);
                    }
                }
                xmlPullParser.next();
            }
        } catch (Exception e) {
            Log.i("LocDVD", "Erreurs trouvées = " + e.getMessage());
            e.printStackTrace();
        }
        //ajouter les datas dans la liste
        listeSeries.setAdapter(adapterFilm);

        final Button btnReturnSeries = findViewById(R.id.btnReturnSeries);
        btnReturnSeries.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Series.this);

                alertDialog.setTitle("Retour");
                alertDialog.setMessage("Voulez vous revenir à la page d'accueil ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Series.this, MainActivity.class);
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
