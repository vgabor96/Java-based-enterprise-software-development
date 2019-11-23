package com.example.sportsbetting.config;

import com.example.sportsbetting.App;
import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Inject;
import java.util.Locale;

@Configuration
//@Import(JpaConfig.class)
public class SportsBettingServiceConfig
{


    @Bean
    public SportsBettingService sportsBettingService()
    {
        SportsBettingService sportsBettingService = new SportsBettingService();


        return sportsBettingService;
    }
}
