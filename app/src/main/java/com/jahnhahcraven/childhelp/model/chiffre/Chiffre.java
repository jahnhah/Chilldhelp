package com.jahnhahcraven.childhelp.model.chiffre;

import java.util.List;

public class Chiffre {
    int id;
    String videoUrl;
    String question;
    List<Double> answers;

    public Chiffre(int id, String videoUrl, String question, List<Double> answers) {
        this.id = id;
        this.videoUrl = videoUrl;
        this.question = question;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Double> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Double> answers) {
        this.answers = answers;
    }
}
