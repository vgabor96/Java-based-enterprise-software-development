package com.sportsbetting.builder;

import com.sportsbetting.domain.Bet;
import com.sportsbetting.domain.Result;
import com.sportsbetting.domain.SportEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportEventBuilder {
    String title;
    LocalDateTime startDate;
    LocalDateTime endDate;
    List<Bet> bets;
    Result result;

    public SportEventBuilder(String title) {
        this.title = title;
        this.bets = new ArrayList<Bet>();
    }
    public SportEventBuilder startDate(LocalDateTime startDate){
        this.startDate = startDate;
        return this;
    }

    public SportEventBuilder endDate(LocalDateTime endDate) {

        this.endDate = endDate;
        return this;
    }

    public SportEventBuilder bets(List<Bet> bets){
        this.bets = bets;
        return this;
    }
    public SportEventBuilder result(Result result){
        this.result = result;
        return this;
    }

    public SportEvent build(){

        SportEvent sportEvent = new SportEvent();
        sportEvent.setTitle(this.title);
        sportEvent.setStartDate(this.startDate);
        sportEvent.setEndDate(this.endDate);
        sportEvent.setBets(this.bets);
        sportEvent.setResult(this.result);

        return sportEvent;
    }

    private SportEventBuilder() {

    }
}
