package com.example.sportsbetting.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Outcome {
    @Id
    @GeneratedValue
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bet bet;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<OutcomeOdd> outcomeOdds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bet getBet() {
        bet.getId();
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
