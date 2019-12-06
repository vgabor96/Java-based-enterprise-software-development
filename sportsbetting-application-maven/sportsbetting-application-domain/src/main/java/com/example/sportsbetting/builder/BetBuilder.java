package com.example.sportsbetting.builder;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.BetType;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.SportEvent;

import java.util.ArrayList;
import java.util.List;

public class BetBuilder {
	private String description;
	private SportEvent event;
    private BetType type;
    private List<Outcome> outcomes;

    public BetBuilder(String description) {
        this.description = description;
        outcomes = new ArrayList<Outcome>();
    }
    public BetBuilder event(SportEvent event){
        this.event = event;
        return this;
    }
    public BetBuilder betType(BetType type){
        this.type = type;
        return this;
    }
    public BetBuilder outComes(List<Outcome> outcomes){
        this.outcomes = outcomes;
        return this;
    }

    public Bet build(){

        Bet bet = new Bet();
        bet.setDescription(this.description);
        bet.setEvent(this.event);
        bet.setType(this.type);
        bet.setOutcomes(this.outcomes);

        return bet;
    }

}
