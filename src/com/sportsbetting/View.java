package com.sportsbetting;

import com.sportsbetting.builder.OutComeBuilder;
import com.sportsbetting.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private List<OutcomeOdd> outComeOdds;

    public View() {
        this.outComeOdds = new ArrayList<OutcomeOdd>();
    }

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

                            this.outComeOdds.add(outcomeodd);
                        }
                    }

                }

            }

        }

    }
    public OutcomeOdd selectOutComeOdd(List<SportEvent> events){


        if (events!=null && !events.isEmpty()) {
            Scanner in = new Scanner(System.in);
            String input;
            do {
                System.out.println("What are you want to bet on? (choose a number or press 'q' for quit");
                printOutcomeOdds(events);
                input = in.nextLine();
                int inputInt = selectOutComeOddInputIsTrue(input,this.outComeOdds.size());
                if (inputInt > -1)
                {
                    return outComeOdds.get(inputInt-1);
                }
            } while (input.equals("q"));


        }
        return null;
    }

    private int selectOutComeOddInputIsTrue(String input,int outcomeOddsSize)
    {
        int value = -1;
        try{
            value = Integer.parseInt(input);
            if (value >=1 && value <=outcomeOddsSize){
                return value;
            }


        }catch (NumberFormatException ex) {

        }
        return value;
    }

    public BigDecimal readWagerAmount(){
        return  BigDecimal.ONE;
    }
    public void printWagerSaved(Wager wager){

    }
    public void printNotEnoughBalance(Player player){
            System.out.println(" You don't have enough money, your balance is "+player.getBalance()+" "+player.getCurrency());
    }
    public void printResults(Player player, List<Wager> wagers){

    }


}
