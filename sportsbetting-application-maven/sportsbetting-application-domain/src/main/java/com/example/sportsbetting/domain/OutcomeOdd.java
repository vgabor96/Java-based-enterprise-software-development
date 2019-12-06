
package com.example.sportsbetting.domain;

import org.hibernate.annotations.Cascade;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OutcomeOdd {
    @Id
    @GeneratedValue
    private int id;

    private BigDecimal value;

    //@Temporal(TemporalType.TIME)
    private LocalDateTime validFrom;
    //@Temporal(TemporalType.TIME)
    private LocalDateTime validUntil;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    //@JoinColumn(name = "Outcome_id")
    private Outcome outcome;

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

    @Transactional
    public Outcome getOutcome() {
       // outcome.getId();

        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
}
