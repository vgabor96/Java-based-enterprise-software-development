package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance
public abstract class SportEvent {
    @Id
    @GeneratedValue
    private int id;


    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private List<Bet> bets;

    @OneToOne(fetch = FetchType.LAZY)
    private Result result;

    @Enumerated(EnumType.STRING)
    private EventType eventtype;
    
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

	public EventType getEventtype() {
		return eventtype;
	}

	public void setEventtype(EventType eventtype) {
		this.eventtype = eventtype;
	}
}
