package com.sportsbetting;

import com.sportsbetting.domain.OutcomeOdd;
import com.sportsbetting.domain.Player;
import com.sportsbetting.domain.SportEvent;
import com.sportsbetting.domain.Wager;

import java.math.BigDecimal;
import java.util.List;

public class View {
    Player readPlayerData(){
        return new Player();
    }

    void printWelcomeMessage(Player player){

    }
    void printBalance(Player player){

    }
    void printOutcomeOdds(List<SportEvent> events){

    }
    OutcomeOdd selectOutComeOdd(List<SportEvent> events){
        return new OutcomeOdd();
    }
    BigDecimal readWagerAmount(){
        return  BigDecimal.ONE;
    }
    void printWagerSaved(Wager wager){

    }
    void printNotEnoughBalance(Player player){

    }
    void printResults(Player player, List<Wager> wagers){
        
    }


}
