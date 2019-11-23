package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bet {
    @Id
    @GeneratedValue
    private int id;

    String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    SportEvent event;

    @Enumerated(EnumType.STRING)
    BetType type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bet_id")
    List<Outcome> outcomes;

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

    public SportEvent getEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
}
