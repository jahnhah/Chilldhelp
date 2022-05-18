package com.jahnhahcraven.childhelp.model.puzzle;

import android.graphics.Bitmap;

public class Tile {
    int numero;
    Bitmap image;

    public Tile(int numero, Bitmap image) {
        this.numero = numero;
        this.image = image;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
