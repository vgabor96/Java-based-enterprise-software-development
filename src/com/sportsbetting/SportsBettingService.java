package com.sportsbetting;

import com.sportsbetting.domain.Player;
import com.sportsbetting.domain.SportEvent;
import com.sportsbetting.domain.Wager;

import java.util.List;

public interface SportsBettingService {
    void savePlayer(Player player);
    Player findPlayer();
    List<SportEvent> findAllSportEvents();
    void saveWager(Wager wager);
    List<Wager>findAllWagers();
    void CalculateResults();

}
