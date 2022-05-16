package com.jahnhahcraven.childhelp.model;

public class Tile {
    int numero;
    String srcUrl;

    public Tile(int numero, String srcUrl) {
        this.numero = numero;
        this.srcUrl = srcUrl;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }
}
