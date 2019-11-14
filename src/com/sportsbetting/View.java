package com.sportsbetting;

import com.sportsbetting.domain.OutcomeOdd;
import com.sportsbetting.domain.Player;
import com.sportsbetting.domain.SportEvent;
import com.sportsbetting.domain.Wager;

import java.math.BigDecimal;
import java.util.List;

public class View {
    public Player readPlayerData(){
        return new Player();
    }

    public void printWelcomeMessage(Player player){

    }
    public void printBalance(Player player){

    }
    public void printOutcomeOdds(List<SportEvent> events){

    }
    public OutcomeOdd selectOutComeOdd(List<SportEvent> events){
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
