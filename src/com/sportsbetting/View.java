package com.sportsbetting;

import com.sportsbetting.builder.OutComeBuilder;
import com.sportsbetting.builder.PlayerBuilder;
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
        Scanner in = new Scanner(System.in);
        String name;
        int balance;
        String currency;
        Currency currency1;

        System.out.println("What is your name?");
        name = in.nextLine();
        System.out.println("How much money do you have (more than 0)?");
        balance = Integer.parseInt(in.nextLine());
        System.out.println("What is your currency? (HUF, EUR or USD) ");
        currency = in.nextLine();
        if (currency.equals(Currency.EUR))
        {
            currency1 = Currency.EUR;
        }
        else if (currency.equals(Currency.USD))
        {
            currency1 = Currency.USD;
        }
        else
        {
            currency1 = Currency.HUF;
        }
        return new PlayerBuilder(name).balance(BigDecimal.valueOf(balance)).currency(currency1).build();
    }

    public void printWelcomeMessage(Player player){
        System.out.println("Welcome "+player.getName()+"!");

    }
    public void printBalance(Player player){
        System.out.println("Your balance is "+player.getBalance()+" "+player.getCurrency());

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
                            i++;
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
            } while (!input.equals("q"));


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
        System.out.println("What amount do you wish to bet on it?");
        Scanner in = new Scanner(System.in);
        String input;
        input = in.nextLine();
        int value = -1;

        try{
            value = Integer.parseInt(input);
            if(value>=0)
            {
                return BigDecimal.valueOf(value);
            }


        }catch (NumberFormatException ex) {
            //not integer
            return BigDecimal.valueOf(-1);
        }
        //negative value
        return  BigDecimal.valueOf(-2);
    }

    public void printWagerSaved(Wager wager){

    }
    public void printNotEnoughBalance(Player player){
            System.out.println(" You don't have enough money, your balance is "+player.getBalance()+" "+player.getCurrency());
    }
    public void printResults(Player player, List<Wager> wagers){

    }


}
