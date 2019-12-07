package com.example.sportsbetting;


import com.example.sportsbetting.domain.*;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;


public  class App {

    public static SportsBettingService sportsBettingService;
    private View view;
    private Player player;
    private List<SportEvent> sportevents;
    private List<Wager> wagers;
    private  OutcomeOdd selectedOutComeOdd;
    public App(SportsBettingService sportsBettingService, View view) {
        App.sportsBettingService = sportsBettingService;
        this.view = view;
        sportevents = new ArrayList<SportEvent>();
        wagers = new ArrayList<Wager>();
    }


    void play() {
        sportevents = sportsBettingService.findAllSportEvents();
        Player player = App.sportsBettingService.findPlayer(0);
        createPlayer();
        view.printWelcomeMessage(this.player);
        view.printBalance(this.player);
        doBetting();
        calculateResults();
        this.player = sportsBettingService.findPlayer(0);
String id =String.valueOf(player.getId());
	App.sportsBettingService.updatePlayer(player.getName(), player.getBirth().toString(), player.getAccountNumber().toString(), player.getCurrency().toString(), player.getBalance().toString(),id);
        printResults();



    }

    private void createPlayer() {
    User player = this.view.readPlayerData();
    App.sportsBettingService.savePlayer(player);
    this.player = App.sportsBettingService.findPlayer(0);
    }

    private void doBetting() {

        do {
            this.selectedOutComeOdd = view.selectOutComeOdd(this.sportevents);
            if(selectedOutComeOdd != null)
            {
                this.WagerCreation();
            }
        }while(selectedOutComeOdd != null);




    }
    private void calculateResults(){

    	App.sportsBettingService.CalculateResults();
    }
    @Transactional
    private void printResults() {

            view.printResults(this.player, this.wagers);
    }

    public static List<Wager> findAllWagers()
    {
        return sportsBettingService.findAllWagers();
    }


    private void WagerCreation() {
        BigDecimal value = BigDecimal.valueOf(0);
        boolean enoughbalance = false;
        player = sportsBettingService.findPlayer(0);
        do {
            value = view.readWagerAmount();
            
            //not integer or negative
            if (value.compareTo(BigDecimal.valueOf(-1)) <=0)
            {
                continue;
            }
            if (value.compareTo(player.getBalance()) <= 0 && player.getBalance().compareTo(BigDecimal.valueOf(0)) >0 && !(value.compareTo(BigDecimal.ZERO) == 0))
            {
                enoughbalance = true;
                player.setBalance(player.getBalance().subtract(value));
                Wager wager = new Wager();
                wager.setPlayer(this.player);
                wager.setAmount(value);
                wager.setCurrency(player.getCurrency());
                wager.setOdd(selectedOutComeOdd);
                wager.setProcessed(false);
               sportsBettingService.saveWager(wager);
                this.wagers = sportsBettingService.findAllWagers();
                view.printWagerSaved(wager);
                sportsBettingService.savePlayer(player);
                view.printBalance(this.player);
            }

            else if((value.compareTo(BigDecimal.ZERO) == 0))
            {
                    break;
            }

            else {
                    view.printNotEnoughBalance(this.player);
            }


        }while( player.getBalance().compareTo(BigDecimal.valueOf(0)) >0 && (value.compareTo(BigDecimal.valueOf(0)) <= 0 || !enoughbalance));


    }


}
