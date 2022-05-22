package com.jahnhahcraven.childhelp.model.puzzle;

import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.Level;

import java.util.List;

public class Puzzle extends Game {
    String text_game;
    int dimension;
    List<Tile> tileList;


    public Puzzle(String text_game, int dimension, List<Tile> tileList) {
        this.text_game = text_game;
        this.dimension = dimension;
        this.tileList = tileList;
    }

    public String getText_game() {
        return text_game;
    }

    public void setText_game(String text_game) {
        this.text_game = text_game;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(List<Tile> tileList) {
        this.tileList = tileList;
    }
}
