package com.example.sportsbetting.domain;

import org.hibernate.annotations.Cascade;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
public class Outcome {
    @Id
    @GeneratedValue
    private int id;

    String description;

    @OneToOne(fetch = FetchType.LAZY)
   // @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    //@JoinColumn(name = "bet_id")
    Bet bet;

    //@OneToMany(fetch = FetchType.LAZY)
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //@JoinColumn(name = "Outcome_id")
    List<OutcomeOdd> outcomeOdds;

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

    @Transactional
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
