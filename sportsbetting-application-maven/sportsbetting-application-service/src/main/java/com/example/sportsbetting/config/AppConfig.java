package com.example.sportsbetting.config;

import com.example.sportsbetting.App;
import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.View;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


import javax.inject.Inject;

@Configuration
@Import({SportsBettingService.class, ViewConfig.class, JpaConfig.class})
public class AppConfig {

    @Inject
    private SportsBettingService sportsBettingService;

    @Inject
    private View view;


    public AppConfig() {
    }

    @Bean
   public App app()
    {
        return new App(sportsBettingService,view);
    }
}
