package com.example.sportsbetting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private  static final Logger LOG = LoggerFactory.getLogger(View.class);
    //private List<OutcomeOdd> outComeOdds;

    public View() {
       // this.outComeOdds = new ArrayList<OutcomeOdd>();
    }

    public Player readPlayerData(){
        Scanner in = new Scanner(System.in);
        String name;
        String sbalance;
        int balance = 0;
        String currency;
        Currency currency1;

       // System.out.println("What is your name?");
        LOG.info("What is your name?");

        name = in.nextLine();
        do {
            //System.out.println("How much money do you have (more than 0)?");
            LOG.info("How much money do you have (more than 0)?");
            sbalance = in.nextLine();
            int value = -1;

            try{
                value = Integer.parseInt(sbalance);
                if(value>=0)
                {
                    balance = value;
                }


            }catch (NumberFormatException ex) {
                //not integer
                balance = -1;
            }


        }while(balance < 0);


        //System.out.println("What is your currency? (HUF, EUR or USD) ");
        LOG.info("What is your currency? (HUF, EUR or USD) ");

        currency = in.nextLine();
        if (currency.equals("EUR"))
        {
            currency1 = Currency.EUR;
        }
        else if (currency.equals("USD"))
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
        //System.out.println("Welcome "+player.getName()+"!");
        LOG.info("Welcome "+player.getName()+"!");

    }
    public void printBalance(Player player){
        //System.out.println("Your balance is "+player.getBalance()+" "+player.getCurrency());
        LOG.info("Your balance is "+player.getBalance()+" "+player.getCurrency());

    }
    public void printOutcomeOdds(List<SportEvent> events){
        if (events!=null && !events.isEmpty())
        {

            int i = 1;
            for (SportEvent event: events) {
                for (Bet bet : event.getBets()) {
                    for (Outcome outcome : bet.getOutcomes()){
                        for (OutcomeOdd outcomeodd : outcome.getOutcomeOdds()){
                            /*System.out.println(i +": Sport Event: "+event.getTitle()
                                    +" (start: "+event.getStartDate()
                                    +"), Bet: "+bet.getDescription()
                                    +", OutCome: "+outcome.getDescription()
                                    +", Actual odd: "+outcomeodd.getValue()
                                    +", Valid between "+ outcomeodd.getValidFrom()
                                    +" and "+ outcomeodd.getValidUntil());
                            */
                            LOG.info(i +": Sport Event: "+event.getTitle()
                                    +" (start: "+event.getStartDate()
                                    +"), Bet: "+bet.getDescription()
                                    +", OutCome: "+outcome.getDescription()
                                    +", Actual odd: "+outcomeodd.getValue()
                                    +", Valid between "+ outcomeodd.getValidFrom()
                                    +" and "+ outcomeodd.getValidUntil());

                            i++;
                        }
                    }

                }

            }

        }

    }
    public OutcomeOdd selectOutComeOdd(List<SportEvent> events){


        if (events!=null && !events.isEmpty()) {
            List<OutcomeOdd> outcomeOdds = new ArrayList<OutcomeOdd>();
            Scanner in = new Scanner(System.in);
            String input;
            int inputInt = 0;
            do {
                //System.out.println("What are you want to bet on? (choose a number or press 'q' for quit");
                LOG.info("What are you want to bet on? (choose a number or press 'q' for quit");
                printOutcomeOdds(events);
                outcomeOdds = GetOutcomeOddsFromEvents(events);
                input = in.nextLine();
                inputInt = selectOutComeOddInputIsTrue(input,outcomeOdds.size());
                if (inputInt > -1)
                {
                    return outcomeOdds.get(inputInt-1);
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
            return -1;
        }
        return -1;
    }

    private List<OutcomeOdd>GetOutcomeOddsFromEvents(List<SportEvent> events) {
        List<OutcomeOdd> outcomeOdds = new ArrayList<>();
        for (SportEvent event : events) {
            for (Bet bet : event.getBets()) {
                for (Outcome outcome : bet.getOutcomes()) {
                    for (OutcomeOdd outcomeodd : outcome.getOutcomeOdds()) {

                        outcomeOdds.add(outcomeodd);
                    }

                }
            }
        }
        return outcomeOdds;
    }
    public BigDecimal readWagerAmount(){
        //System.out.println("What amount do you wish to bet on it?");
        LOG.info("What amount do you wish to bet on it?");
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
        /*System.out.println("Wager '"+wager.getOdd().getOutcome().getBet().getDescription()
                +" = "+wager.getOdd().getOutcome().getDescription()
                +"' of "+wager.getOdd().getOutcome().getBet().getEvent().getTitle()
                +" [odd: "+wager.getOdd().getValue()
                +", amount: "+wager.getAmount()+"] saved!");

         */
        LOG.info("Wager '"+wager.getOdd().getOutcome().getBet().getDescription()
                +" = "+wager.getOdd().getOutcome().getDescription()
                +"' of "+wager.getOdd().getOutcome().getBet().getEvent().getTitle()
                +" [odd: "+wager.getOdd().getValue()
                +", amount: "+wager.getAmount()+"] saved!");
    }
    public void printNotEnoughBalance(Player player){
            //System.out.println(" You don't have enough money, your balance is "+player.getBalance()+" "+player.getCurrency());
        LOG.info(" You don't have enough money, your balance is "+player.getBalance()+" "+player.getCurrency());
    }
    public void printResults(Player player, List<Wager> wagers){
        if (wagers != null && wagers.size()> 0 && player!= null)
        {
            /*System.out.println("Results:");*/
            LOG.info("Results:");

            for ( Wager wager: wagers ){
                /*
                System.out.println("Wager '"+wager.getOdd().getOutcome().getBet().getDescription()
                        +" = "+wager.getOdd().getOutcome().getDescription()
                        +"' of "+wager.getOdd().getOutcome().getBet().getEvent().getTitle()
                        +" [odd: "+wager.getOdd().getValue()
                        +", amount: "+wager.getAmount()+"], win: "+wager.isWin());*/
                LOG.info("Wager '"+wager.getOdd().getOutcome().getBet().getDescription()
                        +" = "+wager.getOdd().getOutcome().getDescription()
                        +"' of "+wager.getOdd().getOutcome().getBet().getEvent().getTitle()
                        +" [odd: "+wager.getOdd().getValue()
                        +", amount: "+wager.getAmount()+"], win: "+wager.isWin());
            }



           /* System.out.println("Your new balance is "+player.getBalance()+ " "+player.getCurrency());*/
            LOG.info("Your new balance is "+player.getBalance()+ " "+player.getCurrency());

        }

    }


}
