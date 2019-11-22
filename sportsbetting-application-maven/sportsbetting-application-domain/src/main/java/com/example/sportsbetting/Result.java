package com.example.sportsbetting;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class Result {
    @Id
    @GeneratedValue
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    List<Outcome> winnerOutcomes;

    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }

    public void setWinnerOutcomes(List<Outcome> winnerOutcomes) {
        this.winnerOutcomes = winnerOutcomes;
    }
}
