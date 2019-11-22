
package com.example.sportsbetting;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OutcomeOdd {
    @Id
    @GeneratedValue
    private int id;

    BigDecimal value;

    @Temporal(TemporalType.DATE)
    LocalDateTime validFrom;
    @Temporal(TemporalType.DATE)
    LocalDateTime validUntil;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Outcome_id")
    Outcome outcome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
}
