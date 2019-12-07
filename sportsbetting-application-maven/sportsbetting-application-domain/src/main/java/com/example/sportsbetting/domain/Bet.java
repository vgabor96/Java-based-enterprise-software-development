package com.example.sportsbetting.domain;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Transactional
public class Bet {
    @Id
    @GeneratedValue
    private int id;

    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    private SportEvent event;

    @Enumerated(EnumType.STRING)
    private BetType type;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Outcome> outcomes;

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
