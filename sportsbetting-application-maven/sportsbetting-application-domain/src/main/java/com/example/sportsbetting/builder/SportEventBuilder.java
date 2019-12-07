package com.example.sportsbetting.builder;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.EventType;
import com.example.sportsbetting.domain.FootballSportEvent;
import com.example.sportsbetting.domain.Result;
import com.example.sportsbetting.domain.TennisSportEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportEventBuilder {
	private String title;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private List<Bet> bets;
	private Result result;
	private EventType eventtype;

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
    
    public SportEventBuilder eventtype(EventType eventtype){
        this.eventtype = eventtype;
        return this;
    }

    public FootballSportEvent buildFootballSportEvent(){

        FootballSportEvent sportEvent = new FootballSportEvent();
        sportEvent.setTitle(this.title);
        sportEvent.setStartDate(this.startDate);
        sportEvent.setEndDate(this.endDate);
        sportEvent.setBets(this.bets);
        sportEvent.setResult(this.result);
        sportEvent.setEventtype(this.eventtype);

        return sportEvent;
    }
    
    public TennisSportEvent buildTennisSportEvent(){

        TennisSportEvent sportEvent = new TennisSportEvent();
        sportEvent.setTitle(this.title);
        sportEvent.setStartDate(this.startDate);
        sportEvent.setEndDate(this.endDate);
        sportEvent.setBets(this.bets);
        sportEvent.setResult(this.result);
        sportEvent.setEventtype(this.eventtype);

        return sportEvent;
    }

}
