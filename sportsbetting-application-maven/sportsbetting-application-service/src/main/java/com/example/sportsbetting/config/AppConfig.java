package com.example.sportsbetting.config;

import com.example.sportsbetting.App;
import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.View;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
    @Bean
   public App app()
    {
        return new App(new SportsBettingService(),new View());
    }
}
