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
    SportsBettingService sportsBettingService;
    View view;
    Player player;
    List<Bet> bets;
    List<Outcome> outcomes;
    List<SportEvent> sportevents;
    List<OutcomeOdd> outcomeOdds;
    List<Wager> wagers;
    OutcomeOdd selectedOutComeOdd;
    public static void main(String[] args)
    {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, JpaConfig.class)){
            App app = appContext.getBean(App.class);
            testJpa(appContext);
            testSpringData(appContext);
            app.play();
        }
    }

    private static void testSpringData(ApplicationContext context){
        PlayerRepository pr =  context.getBean(PlayerRepository.class);
        String name = pr.findById(1).get().getName();
        System.out.println("NÉV: "+name);

    }
    private static void testJpa(ApplicationContext context){
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();

        EntityTransaction tr = em.getTransaction();
        tr.begin();
        Player player = new PlayerBuilder("Józsi").build();
        em.persist(player);
        tr.commit();
       /* this.player = new Player();
        this.sportevents = sportsBettingService.findAllSportEvents();
        this.bets = new ArrayList<Bet>();
        this.outcomes = new ArrayList<Outcome>();
        this.outcomeOdds = new ArrayList<OutcomeOdd>();
        this.wagers = new ArrayList<Wager>();
        this.selectedOutComeOdd = new OutcomeOdd();


        LocalDateTime startDate =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDate =LocalDateTime.parse("2020-01-01 14:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //SPORT EVENT
        SportEvent se = new SportEventBuilder("Arsenal vs Chelsea")
                .startDate(startDate)
                .endDate(endDate)
                .bets(new ArrayList<Bet>())
                .result(new Result())
                .build();
        //BET 1
        Bet bet_1 = new BetBuilder("player Oliver Giroud score")
                .event(se)
                .betType(BetType.PLAYERS_SCORE)
                .outComes(new ArrayList<Outcome>())
                .build();
        //BET 2
        Bet bet_2 = new BetBuilder("number of scored goals")
                .event(se)
                .betType(BetType.GOALS)
                .outComes(new ArrayList<Outcome>())
                .build();

        //OUTCOME 1
        Outcome outcome_1 = new OutComeBuilder("1").
                Bet(bet_1)
                .outComeOdds(new ArrayList<OutcomeOdd>())
                .build();

        //OUTCOME 2
        Outcome outcome_2 = new OutComeBuilder("2").
                Bet(bet_2)
                .outComeOdds(new ArrayList<OutcomeOdd>())
                .build();
        //OUTCOME 3
        Outcome outcome_3 = new OutComeBuilder("3").
                Bet(bet_2)
                .outComeOdds(new ArrayList<OutcomeOdd>())
                .build();

        //OUTCOMEODD 1

        LocalDateTime validfrom_1 =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime validto_1 =LocalDateTime.parse("2020-01-01 12:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        OutcomeOdd outcomeOdd_1 = new OutComeOddBuilder(BigDecimal.valueOf(2))
                .outcome(outcome_1)
                .validFrom(validfrom_1)
                .validUntil(validto_1)
                .build();
        //OUTCOMEODD 2

        LocalDateTime validfrom_2 =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime validto_2 =LocalDateTime.parse("2020-01-01 13:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        OutcomeOdd outcomeOdd_2 = new OutComeOddBuilder(BigDecimal.valueOf(3))
                .outcome(outcome_2)
                .validFrom(validfrom_2)
                .validUntil(validto_2)
                .build();

        //OUTCOMEODD 3

        LocalDateTime validfrom_3 =LocalDateTime.parse("2020-01-01 12:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime validto_3 =LocalDateTime.parse("2020-01-01 13:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        OutcomeOdd outcomeOdd_3 = new OutComeOddBuilder(BigDecimal.valueOf(4))
                .outcome(outcome_2)
                .validFrom(validfrom_3)
                .validUntil(validto_3)
                .build();
        //OUTCOMEODD 4

        LocalDateTime validfrom_4 =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime validto_4 =LocalDateTime.parse("2020-01-01 13:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        OutcomeOdd outcomeOdd_4 = new OutComeOddBuilder(BigDecimal.valueOf(6))
                .outcome(outcome_3)
                .validFrom(validfrom_4)
                .validUntil(validto_4)
                .build();

        //SETUP OUTCOMES OUTCOMEODDS
        outcome_1.getOutcomeOdds().add(outcomeOdd_1);
        outcome_2.getOutcomeOdds().add(outcomeOdd_2);
        outcome_2.getOutcomeOdds().add(outcomeOdd_3);
        outcome_3.getOutcomeOdds().add(outcomeOdd_4);

        //SETUP BETS OUTCOMES
        bet_1.getOutcomes().add(outcome_1);
        bet_2.getOutcomes().add(outcome_2);
        bet_2.getOutcomes().add(outcome_3);

        //SETUP SPORTEVENT
        se.getBets().add(bet_1);
        se.getBets().add(bet_2);

        //Initialize fields with temps
        this.sportevents.add(se);
        this.bets.add(bet_1);
        this.bets.add(bet_2);
        this.outcomes.add(outcome_1);
        this.outcomes.add(outcome_2);
        this.outcomes.add(outcome_3);
        this.outcomeOdds.add(outcomeOdd_1);
        this.outcomeOdds.add(outcomeOdd_2);
        this.outcomeOdds.add(outcomeOdd_3);
        this.outcomeOdds.add(outcomeOdd_4);

        em.persist(se);
        em.persist(bet_1);
        em.persist(bet_2);
        em.persist(outcome_1);
        em.persist(outcome_2);
        em.persist(outcome_3);
        em.persist(outcomeOdd_1);
        em.persist(outcomeOdd_2);
        em.persist(outcomeOdd_3);
        em.persist(outcomeOdd_4);
        */



        em.close();
    }

}
