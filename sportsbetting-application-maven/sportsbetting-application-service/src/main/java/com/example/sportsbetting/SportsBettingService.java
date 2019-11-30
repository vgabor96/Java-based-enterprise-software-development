package com.example.sportsbetting;

import com.example.sportsbetting.builder.*;
import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Transactional
@Service
public  class SportsBettingService {
    private Random r;
    private static List<SportEvent> sportEvents;
    
    
    
    @Autowired
    private   BetRepository betRepository;
    @Autowired
    private  OutComeOddRepository outComeOddRepository;
    @Autowired
    private  OutComeRepository outComeRepository;
    @Autowired
    private  PlayerRepository playerRepository;
    @Autowired
    private  ResultRepository resultRepository;
    @Autowired
    private  SportEventRepository sportEventRepository;
    @Autowired
    private  WagerRepository wagerRepository;


    public SportsBettingService() {


    	
        this.r = new Random();


    }
     void Initialize(){
        /*this.player = new Player();
        this.sportevents = sportsBettingService.findAllSportEvents();
        this.bets = new ArrayList<Bet>();
        this.outcomes = new ArrayList<Outcome>();
        this.outcomeOdds = new ArrayList<OutcomeOdd>();
        this.wagers = new ArrayList<Wager>();
        this.selectedOutComeOdd = new OutcomeOdd();


         */


        LocalDateTime startDate =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDate =LocalDateTime.parse("2020-01-01 14:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //SPORT EVENT
        SportEvent se = new SportEventBuilder("Arsenal vs Chelsea")
                .startDate(startDate)
                .endDate(endDate)
                .build();
        //BET 1
        Bet bet_1 = new BetBuilder("player Oliver Giroud score")
                .event(se)
                .betType(BetType.PLAYERS_SCORE)
                .build();
        //BET 2
        Bet bet_2 = new BetBuilder("number of scored goals")
                .event(se)
                .betType(BetType.GOALS)
                .build();

        //OUTCOME 1
        Outcome outcome_1 = new OutComeBuilder("1").
                Bet(bet_1)
                .build();

        //OUTCOME 2
        Outcome outcome_2 = new OutComeBuilder("2").
                Bet(bet_2)
                .build();
        //OUTCOME 3
        Outcome outcome_3 = new OutComeBuilder("3").
                Bet(bet_2)
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




        /*
        this.bets.add(bet_1);
        this.bets.add(bet_2);
        this.outcomes.add(outcome_1);
        this.outcomes.add(outcome_2);
        this.outcomes.add(outcome_3);

         */

        /*this.outcomeOdds.add(outcomeOdd_1);
        this.outcomeOdds.add(outcomeOdd_2);
        this.outcomeOdds.add(outcomeOdd_3);
        this.outcomeOdds.add(outcomeOdd_4);

*/




        //em.persist(se);



        /*Query q = em.createQuery("SELECT b FROM Bet b JOIN FETCH b.items i WHERE o.id = :id");
        q.setParameter("id", orderId);
        newOrder = (Order) q.getSingleResult();
        */

        sportEventRepository.save(se);
        //SportEvent se2 = sportEventRepository.findAll().get(0);
        betRepository.save(bet_1);
        betRepository.save(bet_2);


        outComeRepository.save(outcome_1);
        outComeRepository.save(outcome_2);
        outComeRepository.save(outcome_3);


        outComeOddRepository.save(outcomeOdd_1);
        outComeOddRepository.save(outcomeOdd_2);
        outComeOddRepository.save(outcomeOdd_3);
        outComeOddRepository.save(outcomeOdd_4);
        //SportEvent se3 =findAllSportEvents().get(0);



        //System.out.println(se3.getTitle());
        /*
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


        tr.commit();
*/


    }

    @Autowired
    public void setRepositories(ApplicationContext context) {

        betRepository = context.getBean(BetRepository.class);
        outComeOddRepository = context.getBean(OutComeOddRepository.class);
        outComeRepository = context.getBean(OutComeRepository.class);
        playerRepository = context.getBean(PlayerRepository.class);
        resultRepository = context.getBean(ResultRepository.class);
        sportEventRepository = context.getBean(SportEventRepository.class);
        wagerRepository = context.getBean(WagerRepository.class);



        Initialize();

    }

    public void ReInitRepos()
    {
       betRepository.count();
       outComeOddRepository.count();
       outComeRepository.count();
       playerRepository.count();
       resultRepository.count();
       sportEventRepository.count();
       wagerRepository.count();

    }

    public void savePlayer(Player player){
        //this.player = player;
        playerRepository.save(player);
    }
    public Player findPlayer() {

        return playerRepository.findAll().get(0);
    }
    @Transactional
    public  List<SportEvent>  findAllSportEvents() {
        //sportEvents = sportEventRepository.findAll();

        return sportEventRepository.findAll();
    }
    public Wager saveWager(Wager wager){

        return wagerRepository.save(wager);
    }
    @Transactional
    public List<Wager>findAllWagers()  {


        return  wagerRepository.findAll();
    }

    private Wager Randomwinner()
    {
        List<Wager> wagers = wagerRepository.findAll();
        int randomwinnerwage = r.nextInt(wagers.size());
        Wager wg = wagers.get(randomwinnerwage);
        return wg;

    }

    public void CalculateResults() {
        if (wagerRepository.count()>0 && playerRepository.count()>0) {
            Wager wg = Randomwinner();
            ArrayList<Outcome> winneroutcomes = new ArrayList<Outcome>();
            Result r = new Result();
            for (Wager wager : findAllWagers()) {
                if (wager.getId() == wg.getId()) {
                    wager.setWin(true);
                  winneroutcomes.add(wager.getOdd().getOutcome());

                    findPlayer().setBalance(findPlayer().getBalance().add(wager.getAmount().multiply(wager.getOdd().getValue())));
                    wager.setProcessed(true);
                    saveWager(wager);
                }
            }
            r.setWinnerOutcomes(winneroutcomes);
            resultRepository.save(r);
        }
    }

}
