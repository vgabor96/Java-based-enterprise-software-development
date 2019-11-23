package com.example.sportsbetting;

import com.example.sportsbetting.config.JpaConfig;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Result;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.repository.*;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SportsBettingService {
    private Player player;
    private List<SportEvent> sportevents;
    private List<Wager> wagers;
    private Random r;
    public ApplicationContext context;
    private BetRepository betRepository;
    private OutComeOddRepository outComeOddRepository;
    private OutComeRepository outComeRepository;
    private PlayerRepository playerRepository;
    private ResultRepository resultRepository;
    private SportEventRepository sportEventRepository;
    private WagerRepository wagerRepository;


    public SportsBettingService() {
        this.player = new Player();
        this.sportevents = new ArrayList<SportEvent>();
        this.wagers = new ArrayList<Wager>();
        this.r = new Random();

    }

    public void setRepositories(ApplicationContext context) {

        this.betRepository = context.getBean(BetRepository.class);
        this.outComeOddRepository = context.getBean(OutComeOddRepository.class);
        this.outComeRepository = context.getBean(OutComeRepository.class);
        this.playerRepository = context.getBean(PlayerRepository.class);
        this.resultRepository = context.getBean(ResultRepository.class);
        this.sportEventRepository = context.getBean(SportEventRepository.class);
        this.wagerRepository = context.getBean(WagerRepository.class);

    }

    public void savePlayer(Player player){
        //this.player = player;
        this.playerRepository.save(player);
    }
    public Player findPlayer() {

        return this.playerRepository.findById(1).get();
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
    public void CalculateResults() {
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
