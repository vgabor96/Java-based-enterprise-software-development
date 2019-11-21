package com.example.sportsbetting.config;

import com.example.sportsbetting.App;
import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.View;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@Configuration
public class AppConfig {
    @Value("${default.language}")
    private Locale locale;

    @Inject
    private MessageSource messageSource;

    @Bean
   public App app()
    {
        return new App(new SportsBettingService(),new View());
    }
}
