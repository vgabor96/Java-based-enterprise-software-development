package com.example.sportsbetting.repository;

import com.example.sportsbetting.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player,Integer> {

    @Override
    public List<Player> findAll();
}
