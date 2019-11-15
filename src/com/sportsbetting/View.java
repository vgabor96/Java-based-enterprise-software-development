package com.sportsbetting;

import com.sportsbetting.builder.OutComeBuilder;
import com.sportsbetting.domain.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class View {
    public Player readPlayerData(){
        return new Player();
    }

    public void printWelcomeMessage(Player player){

    }
    public void printBalance(Player player){

    }
    public void printOutcomeOdds(List<SportEvent> events){
        if (events!=null && !events.isEmpty())
        {
            int i = 1;
            for (SportEvent event: events) {
                for (Bet bet : event.getBets()) {
                    for (Outcome outcome : bet.getOutcomes()){
                        for (OutcomeOdd outcomeodd : outcome.getOutcomeOdds()){
                            System.out.println(i +": Sport Event: "+event.getTitle()
                                    +" (start: "+event.getStartDate()
                                    +"), Bet: "+bet.getDescription()
                                    +", OutCome: "+outcome.getDescription()
                                    +", Actual odd: "+outcomeodd.getValue()
                                    +", Valid between "+ outcomeodd.getValidFrom()
                                    +" and "+ outcomeodd.getValidUntil());
                        }
                    }

                }

            }

        }

    }
    public OutcomeOdd selectOutComeOdd(List<SportEvent> events){

        do {
            printOutcomeOdds(events);

        }while();
        Scanner in = new Scanner(System.in);
        String input;
        return new OutcomeOdd();
    }
    public BigDecimal readWagerAmount(){
        return  BigDecimal.ONE;
    }
    public void printWagerSaved(Wager wager){

    }
    public void printNotEnoughBalance(Player player){

    }
    public void printResults(Player player, List<Wager> wagers){

    }


}
