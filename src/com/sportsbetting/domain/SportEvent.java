package com.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

public class SportEvent {
    String title;
    LocalDateTime startDate;
    LocalDateTime endDate;
    List<Bet> bets;
    Result result;

}
