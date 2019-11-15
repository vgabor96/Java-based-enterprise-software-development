package com.sportsbetting;

import com.sportsbetting.domain.Player;
import com.sportsbetting.domain.SportEvent;
import com.sportsbetting.domain.Wager;

import java.util.ArrayList;
import java.util.List;

public class SportsBettingService {
    private Player player;
    private List<SportEvent> sportevents;
    private List<Wager> wagers;

    public SportsBettingService() {
        this.player = new Player();
        this.sportevents = new ArrayList<SportEvent>();
        this.wagers = new ArrayList<Wager>();
    }

    public void savePlayer(Player player){
        this.player = player;
    }
    public Player findPlayer() {
        return this.player;
    }
    public List<SportEvent> findAllSportEvents() {
        return this.sportevents ;
    }
    public void saveWager(Wager wager){
        this.wagers.add(wager);
    }
    public List<Wager>findAllWagers()  {
        return this.wagers;
    }
    public void CalculateResults()
    {

    }

}
