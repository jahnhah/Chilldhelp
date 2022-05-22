package com.jahnhahcraven.childhelp.model.chiffre;

import com.jahnhahcraven.childhelp.model.Game;

import java.util.ArrayList;
import java.util.List;

public class Chiffre extends Game {
    double result;
    ArrayList<Double> number_game;

    public Chiffre(double result, ArrayList<Double> number_game) {
        this.result = result;
        this.number_game = number_game;
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
}
