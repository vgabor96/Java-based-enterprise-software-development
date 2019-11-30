package com.example.sportsbetting;

import com.example.sportsbetting.builder.*;
import com.example.sportsbetting.config.AppConfig;
import com.example.sportsbetting.config.JpaConfig;
import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.repository.BetRepository;
import com.example.sportsbetting.repository.PlayerRepository;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppSpring {

    public static void main(String[] args)
    {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, JpaConfig.class)){
            App app = appContext.getBean(App.class);
            //app.sportsBettingService.setRepositories(appContext);

            /*testJpa(appContext);
            testSpringData(appContext);

             */
            app.play();
            System.out.println("PROGRAM ENDS");
        }
    }

  

}
