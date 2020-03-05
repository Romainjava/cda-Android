package data.cineclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class FilmAdapter extends ArrayAdapter<Film> {

    public FilmAdapter(@NonNull Context context, int textViewRessourceId) {
        super(context, textViewRessourceId);
    }

    @NonNull
    @Override
    //Surcharge de la methode getView pour prise en compte du LinearLayout spécifique ligne.xml
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View result = convertView;
        if(convertView == null){
           result = LayoutInflater.from(getContext()).inflate(R.layout.ligne,parent,false);
       }
       Film film = getItem(position);

       //Assigner aux textView les valeurs obtenues par les get de la classe Film
        TextView titre = result.findViewById(R.id.titleLigne);
        titre.setText(film.getStrTitle());

        TextView realisateur = result.findViewById(R.id.realisateurLigne);
        realisateur.setText(film.getStrRealisateur());

        ImageView imageview = result.findViewById(R.id.imageView);
        imageview.setImageResource(film.getImg());

       return result;
    }

    //Notification à la vue principale des changements de la ListView
    public void updateData(){
        this.notifyDataSetChanged();
    }

}
