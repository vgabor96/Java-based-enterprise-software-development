package com.sportsbetting;

public class App {

    SportsBettingService sportsBettingService;
    View view;
    public App(SportsBettingService sportsBettingService, View view) {
        this.sportsBettingService = sportsBettingService;
        this.view = view;
    }

    public static void main(String[] args) {
        App app = new App(new SportsBettingService(), new View());
        app.play();
    }

    void play() {


    }

    void createPlayer() {

    }
    void calculateResults(){

    }
    void printResults(){

    }
}
