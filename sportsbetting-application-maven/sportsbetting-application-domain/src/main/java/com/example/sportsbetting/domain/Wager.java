package com.example.sportsbetting.domain;
import org.hibernate.annotations.Cascade;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Wager {
    @Id
    @GeneratedValue
    private int id;

    private BigDecimal amount;
    //@Temporal(TemporalType.TIME)
    private LocalDateTime timestampCreated;
    boolean processed;
    boolean win;
    @OneToOne(fetch = FetchType.EAGER)
    //@Cascade(org.hibernate.annotations.CascadeType.MERGE)
    //@JoinColumn(name = "wager_outcomeOdd_id")
    private OutcomeOdd odd;
    @OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "wager_player_id")
    private Player player;
    @Enumerated(EnumType.STRING)
    private Currency currency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    @Transactional
    public OutcomeOdd getOdd() {

        odd.getOutcome().getBet().getId();

        return odd;
    }

    public void setOdd(OutcomeOdd odd) {
        this.odd = odd;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    public String getEventTitle(){
      return this.getOdd().getOutcome().getBet().getEvent().getTitle();
    }
    
}
