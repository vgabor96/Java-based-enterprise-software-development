package com.example.sportsbetting.repository;

import com.example.sportsbetting.domain.SportEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public interface SportEventRepository  extends CrudRepository<SportEvent,Integer> {
    @Override
    public List<SportEvent> findAll();
}
