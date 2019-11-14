package com.sportsbetting;

import com.sportsbetting.domain.Player;
import com.sportsbetting.domain.Wager;

import java.util.ArrayList;

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

    void doBetting(){

    }
    void calculateResults(){
        this.sportsBettingService.CalculateResults();
    }
    void printResults(){
    view.printResults(new Player(), new ArrayList<Wager>());
    }

    void Initialize(){

    }
}
