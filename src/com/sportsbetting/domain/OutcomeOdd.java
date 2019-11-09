package com.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOdd {
    BigDecimal value;
    LocalDateTime validFrom;
    LocalDateTime validUntil;
    Outcome outcome;
}
