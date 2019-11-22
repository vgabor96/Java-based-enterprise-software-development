package com.example.sportsbetting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SportsBettingService {
    private Player player;
    private List<SportEvent> sportevents;
    private List<Wager> wagers;
    private Random r;

    public SportsBettingService() {
        this.player = new Player();
        this.sportevents = new ArrayList<SportEvent>();
        this.wagers = new ArrayList<Wager>();
        this.r = new Random();
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
        if (wagers != null && wagers.size()> 0 && player!= null) {
            int randomwinnerwage = r.nextInt(this.wagers.size());
            this.wagers.get(randomwinnerwage).setWin(true);

            for (Wager wager : findAllWagers()) {
                if (wager.isWin()) {
                    findPlayer().setBalance(findPlayer().getBalance().add(wager.getAmount().multiply(wager.getOdd().getValue())));
                }
            }
        }
    }

}
