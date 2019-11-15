package com.sportsbetting;

import com.sportsbetting.builder.BetBuilder;
import com.sportsbetting.builder.OutComeBuilder;
import com.sportsbetting.builder.OutComeOddBuilder;
import com.sportsbetting.builder.SportEventBuilder;
import com.sportsbetting.domain.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    SportsBettingService sportsBettingService;
    View view;
    Player player;
    List<Bet> bets;
    List<Outcome> outcomes;
    List<SportEvent> sportevents;
    List<OutcomeOdd> outcomeOdds;
    List<Wager> wagers;
    OutcomeOdd selectedOutComeOdd;
    public App(SportsBettingService sportsBettingService, View view) {
        this.sportsBettingService = sportsBettingService;
        this.view = view;
        Initialize();
    }

    public static void main(String[] args)
    {
        App app = new App(new SportsBettingService(), new View());
        app.play();
    }

    void play() {
        createPlayer();
        view.printWelcomeMessage(this.player);
        view.printBalance(this.player);
        doBetting();
        sportsBettingService.CalculateResults();



    }

    void createPlayer() {
    Player player = this.view.readPlayerData();
    this.sportsBettingService.savePlayer(player);
    this.player = this.sportsBettingService.findPlayer();
    }

    void doBetting() {

        do {
            this.selectedOutComeOdd = view.selectOutComeOdd(this.sportevents);
            if(selectedOutComeOdd != null)
            {
                this.WagerCreation();
            }
        }while(selectedOutComeOdd != null);




    }
    void calculateResults(){

        this.sportsBettingService.CalculateResults();
    }
    void printResults() {

    view.printResults(new Player(), new ArrayList<Wager>());

    }

    private void WagerCreation()
    {
        BigDecimal value = BigDecimal.valueOf(0);
        boolean enoughbalance = false;
        do {
            value = view.readWagerAmount();
            //not integer or negative
            if (value.compareTo(BigDecimal.valueOf(-1)) <= 0)
            {
                continue;
            }
            if (value.compareTo(player.getBalance()) <= 0)
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
                view.printWagerSaved(wager);
                view.printBalance(this.player);

            }
            else
            {
                view.printNotEnoughBalance(this.player);
            }


        }while(value.compareTo(BigDecimal.valueOf(0)) <= 0 || !enoughbalance);


    }

    void Initialize(){
        this.player = new Player();
        this.sportevents = new ArrayList<SportEvent>();
        this.bets = new ArrayList<Bet>();
        this.outcomes = new ArrayList<Outcome>();
        this.outcomeOdds = new ArrayList<OutcomeOdd>();
        this.wagers = new ArrayList<Wager>();
        this.selectedOutComeOdd = new OutcomeOdd();


        LocalDateTime startDate =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDate =LocalDateTime.parse("2020-01-01 14:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //SPORT EVENT
        SportEvent se = new SportEventBuilder("Arsenal vs Chelsea")
                .startDate(startDate)
                .endDate(endDate)
                .bets(new ArrayList<Bet>())
                .result(new Result())
                .build();
        //BET 1
        Bet bet_1 = new BetBuilder("player Oliver Giroud score")
                .event(se)
                .betType(BetType.PLAYERS_SCORE)
                .outComes(new ArrayList<Outcome>())
                .build();
        //BET 2
        Bet bet_2 = new BetBuilder("number of scored goals")
                .event(se)
                .betType(BetType.GOALS)
                .outComes(new ArrayList<Outcome>())
                .build();

        //OUTCOME 1
        Outcome outcome_1 = new OutComeBuilder("1").
                Bet(bet_1)
                .outComeOdds(new ArrayList<OutcomeOdd>())
                .build();

        //OUTCOME 2
        Outcome outcome_2 = new OutComeBuilder("2").
                Bet(bet_2)
                .outComeOdds(new ArrayList<OutcomeOdd>())
                .build();
        //OUTCOME 3
        Outcome outcome_3 = new OutComeBuilder("3").
                Bet(bet_2)
                .outComeOdds(new ArrayList<OutcomeOdd>())
                .build();

        //OUTCOMEODD 1

        LocalDateTime validfrom_1 =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime validto_1 =LocalDateTime.parse("2020-01-01 12:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        OutcomeOdd outcomeOdd_1 = new OutComeOddBuilder(BigDecimal.valueOf(2))
                .outcome(outcome_1)
                .validFrom(validfrom_1)
                .validUntil(validto_1)
                .build();
        //OUTCOMEODD 2

        LocalDateTime validfrom_2 =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime validto_2 =LocalDateTime.parse("2020-01-01 13:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        OutcomeOdd outcomeOdd_2 = new OutComeOddBuilder(BigDecimal.valueOf(3))
                .outcome(outcome_2)
                .validFrom(validfrom_2)
                .validUntil(validto_2)
                .build();

        //OUTCOMEODD 3

        LocalDateTime validfrom_3 =LocalDateTime.parse("2020-01-01 12:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime validto_3 =LocalDateTime.parse("2020-01-01 13:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        OutcomeOdd outcomeOdd_3 = new OutComeOddBuilder(BigDecimal.valueOf(4))
                .outcome(outcome_2)
                .validFrom(validfrom_3)
                .validUntil(validto_3)
                .build();
        //OUTCOMEODD 4

        LocalDateTime validfrom_4 =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime validto_4 =LocalDateTime.parse("2020-01-01 13:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        OutcomeOdd outcomeOdd_4 = new OutComeOddBuilder(BigDecimal.valueOf(6))
                .outcome(outcome_3)
                .validFrom(validfrom_4)
                .validUntil(validto_4)
                .build();

        //SETUP OUTCOMES OUTCOMEODDS
        outcome_1.getOutcomeOdds().add(outcomeOdd_1);
        outcome_2.getOutcomeOdds().add(outcomeOdd_2);
        outcome_2.getOutcomeOdds().add(outcomeOdd_3);
        outcome_3.getOutcomeOdds().add(outcomeOdd_4);

        //SETUP BETS OUTCOMES
        bet_1.getOutcomes().add(outcome_1);
        bet_2.getOutcomes().add(outcome_2);
        bet_2.getOutcomes().add(outcome_3);

        //SETUP SPORTEVENT
        se.getBets().add(bet_1);
        se.getBets().add(bet_2);

        //Initialize fields with temps
        this.sportevents.add(se);
        this.bets.add(bet_1);
        this.bets.add(bet_2);
        this.outcomes.add(outcome_1);
        this.outcomes.add(outcome_2);
        this.outcomes.add(outcome_3);
        this.outcomeOdds.add(outcomeOdd_1);
        this.outcomeOdds.add(outcomeOdd_2);
        this.outcomeOdds.add(outcomeOdd_3);
        this.outcomeOdds.add(outcomeOdd_4);




    }
}
