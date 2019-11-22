package com.example.sportsbetting.builders;

import com.example.sportsbetting.Outcome;
import com.example.sportsbetting.OutcomeOdd;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutComeOddBuilder {

    BigDecimal value;
    LocalDateTime validFrom;
    LocalDateTime validUntil;
    Outcome outcome;

    public OutComeOddBuilder(BigDecimal value) {
        this.value = value;

    }
    public OutComeOddBuilder validFrom(LocalDateTime validFrom){
        this.validFrom = validFrom;
        return this;
    }

    public OutComeOddBuilder validUntil(LocalDateTime validUntil) {

        this.validUntil = validUntil;
        return this;
    }
    public OutComeOddBuilder outcome(Outcome outcome) {

        this.outcome = outcome;
        return this;
    }

    public OutcomeOdd build(){

        OutcomeOdd outcomeOdd = new OutcomeOdd();
        outcomeOdd.setValue(this.value);
        outcomeOdd.setOutcome(this.outcome);
        outcomeOdd.setValidFrom(this.validFrom);
        outcomeOdd.setValidUntil(this.validUntil);

        return outcomeOdd;
    }

    private OutComeOddBuilder() {

    }
}
