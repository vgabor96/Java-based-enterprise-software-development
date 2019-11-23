package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class SportEvent {
    @Id
    @GeneratedValue
    private int id;


    String title;
    //@Temporal(TemporalType.TIME)
    LocalDateTime startDate;
    //@Temporal(TemporalType.TIME)
    LocalDateTime endDate;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportevent_id")
    List<Bet> bets;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id")
    Result result;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
