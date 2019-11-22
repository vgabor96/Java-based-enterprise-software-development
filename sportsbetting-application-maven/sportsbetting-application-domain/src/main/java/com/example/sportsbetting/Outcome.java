package com.example.sportsbetting;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class Outcome {
    @Id
    @GeneratedValue
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    String description;
    Bet bet;
    List<OutcomeOdd> outcomeOdds;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }

    public void setOutcomeOdds(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
    }
}
