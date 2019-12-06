package com.example.sportsbetting.builder;

import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutComeOddBuilder {

	private BigDecimal value;
	private LocalDateTime validFrom;
	private LocalDateTime validUntil;
	private Outcome outcome;

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
}
