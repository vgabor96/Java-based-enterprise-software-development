package com.example.sportsbetting.repository;

import com.example.sportsbetting.domain.SportEvent;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface SportEventRepository  extends CrudRepository<SportEvent,Integer> {
    @Override
    public List<SportEvent> findAll();
}
