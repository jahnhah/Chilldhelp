package com.jahnhahcraven.childhelp.model;

import com.jahnhahcraven.childhelp.model.puzzle.Tile;

import java.util.ArrayList;
import java.util.List;

public class Game {
    String _id,media,gametype;
    int level;
    int dimension;
    double result;
    ArrayList<Double> number_game;
    String text_game;
    List<Tile> tileList;

    public Game() {
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public ArrayList<Double> getNumber_game() {
        return number_game;
    }

    public void setNumber_game(ArrayList<Double> number_game) {
        this.number_game = number_game;
    }

    public String getText_game() {
        return text_game;
    }

    public void setText_game(String text_game) {
        this.text_game = text_game;
    }

    public List<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(List<Tile> tileList) {
        this.tileList = tileList;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getGameType() {
        return gametype;
    }

    public void setGameType(String gameType) {
        this.gametype = gameType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
