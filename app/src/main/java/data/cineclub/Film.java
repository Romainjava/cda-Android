package data.cineclub;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class Film {
    String strTitle;
    String strRealisateur;
    String strCat;
    int img;

    // MUTATEUR && ACCESSEURS //

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public String getStrRealisateur() {
        return strRealisateur;
    }

    public void setStrRealisateur(String strRealisateur) {
        this.strRealisateur = strRealisateur;
    }

    public String getStrCat() {
        return strCat;
    }

    public void setStrCat(String strCat) {
        this.strCat = strCat;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
