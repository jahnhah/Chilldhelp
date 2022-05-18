package com.jahnhahcraven.childhelp.model.puzzle;

import com.jahnhahcraven.childhelp.model.Level;

import java.util.List;

public class Puzzle {
    int id;
    Level level;
    List<Tile> tileList;
    String imgUrl;

    public Puzzle(int id, Level level, List<Tile> tileList, String imgUrl) {
        this.id = id;
        this.level = level;
        this.tileList = tileList;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(List<Tile> tileList) {
        this.tileList = tileList;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
