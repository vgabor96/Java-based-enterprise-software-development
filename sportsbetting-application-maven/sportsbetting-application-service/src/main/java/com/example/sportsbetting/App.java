package com.example.sportsbetting;

import com.example.sportsbetting.builder.BetBuilder;
import com.example.sportsbetting.builder.OutComeBuilder;
import com.example.sportsbetting.builder.OutComeOddBuilder;
import com.example.sportsbetting.builder.SportEventBuilder;
import com.example.sportsbetting.config.JpaConfig;
import com.example.sportsbetting.domain.*;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public  class App {

    public static SportsBettingService sportsBettingService;
    private View view;
    private Player player;
    private List<SportEvent> sportevents;
    private List<Wager> wagers;
    private List<Result> results;
    private  OutcomeOdd selectedOutComeOdd;
    public App(SportsBettingService sportsBettingService, View view) {
        this.sportsBettingService = sportsBettingService;
        this.view = view;
        sportevents = new ArrayList<SportEvent>();
        wagers = new ArrayList<Wager>();
    }


    void play() {
        sportevents = sportsBettingService.findAllSportEvents();
        Player player = this.sportsBettingService.findPlayer(0);
        String name = player.getName();
  		String birth = player.getBirth().toString();
  		String accountnumber = player.getAccountNumber().toString();
  		String currency = player.getCurrency().toString();
  		String balance = player.getBalance().toString();
        createPlayer();
        view.printWelcomeMessage(this.player);
        view.printBalance(this.player);
        doBetting();
        calculateResults();
        this.player = sportsBettingService.findPlayer(0);
String id =String.valueOf(player.getId());
        this.sportsBettingService.updatePlayer(player.getName(), player.getBirth().toString(), player.getAccountNumber().toString(), player.getCurrency().toString(), player.getBalance().toString(),id);
        printResults();



    }

    private void createPlayer() {
    User player = this.view.readPlayerData();
    this.sportsBettingService.savePlayer(player);
    this.player = this.sportsBettingService.findPlayer(0);
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

        this.sportsBettingService.CalculateResults();
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
                //wager.setTimestampCreated();
                //wager.setWin();
               sportsBettingService.saveWager(wager);
                //this.wagers.add(wager);
                this.wagers = sportsBettingService.findAllWagers();
                //this.wagers = sportsBettingService.findAllWagers();
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
