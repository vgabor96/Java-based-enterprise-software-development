package com.example.sportsbetting.config;

import com.example.sportsbetting.App;
import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.View;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import org.springframework.context.annotation.PropertySource;

import javax.inject.Inject;
import java.util.Locale;

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
