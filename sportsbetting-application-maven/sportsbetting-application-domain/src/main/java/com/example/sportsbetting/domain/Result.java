package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "result_id")
    List<Outcome> winnerOutcomes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }

    public void setWinnerOutcomes(List<Outcome> winnerOutcomes) {
        this.winnerOutcomes = winnerOutcomes;
    }
}
