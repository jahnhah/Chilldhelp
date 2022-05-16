package com.jahnhahcraven.childhelp.model;

public class GameType {
    int id;
    String name;
    String srcUrl;

    public GameType(int id, String name, String srcUrl) {
        this.id = id;
        this.name = name;
        this.srcUrl = srcUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }
}
