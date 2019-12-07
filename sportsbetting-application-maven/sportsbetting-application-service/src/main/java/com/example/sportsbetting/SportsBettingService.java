package com.example.sportsbetting;

import com.example.sportsbetting.builder.*;
import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Transactional
@Service
public  class SportsBettingService {
    private Random r;
    
    
    @Autowired
    private   BetRepository betRepository;
    @Autowired
    private  OutComeOddRepository outComeOddRepository;
    @Autowired
    private  OutComeRepository outComeRepository;
    @Autowired
    private  ResultRepository resultRepository;
    @Autowired
    private  SportEventRepository sportEventRepository;
    @Autowired
    private  WagerRepository wagerRepository;
    @Autowired
    private UserRepository userRepository;


    public SportsBettingService() {


    	
        this.r = new Random();


    }
    private void initialize(){

        LocalDateTime startDate =LocalDateTime.parse("2020-01-01 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDate =LocalDateTime.parse("2020-01-01 14:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //SPORT EVENT
        SportEvent se = new SportEventBuilder("Arsenal vs Chelsea")
                .startDate(startDate)
                .endDate(endDate)
                .eventtype(EventType.FOOTBALLMATCH)
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
                bet(bet_1)
                .build();

        //OUTCOME 2
        Outcome outcome_2 = new OutComeBuilder("2").
                bet(bet_2)
                .build();
        //OUTCOME 3
        Outcome outcome_3 = new OutComeBuilder("3").
                bet(bet_2)
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

      	 Player player = new PlayerBuilder("Laszlo")
    			 .birth(LocalDate.of(1999, 8, 10))
    			 .accountnumber(666666)
    			 .currency(Currency.HUF)
    			 .balance(BigDecimal.valueOf(99956)).build();

    	 
    	 User user = new User("loa","password",player);
    	 
    	 Player player2 = new PlayerBuilder("Gabor")
    			 .birth(LocalDate.of(1996, 8, 4))
    			 .accountnumber(12345678)
    			 .currency(Currency.EUR)
    			 .balance(BigDecimal.valueOf(100)).build();

    	 
    	 User user2 = new User("loa2","password",player2);
    	 
    	 
    	 
        Wager w1 = new WagerBuilder(BigDecimal.valueOf(100))
        		.timestampCreated(LocalDateTime.parse("2020-01-03 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        		.processed(false)
        		.win(false)
        		.currency(Currency.HUF)
        		.player(user)
        		.odd(outcomeOdd_1)
        		.build();
        Wager w2 =  new WagerBuilder(BigDecimal.valueOf(56))
        		.timestampCreated(LocalDateTime.parse("2020-01-01 13:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        		.processed(false)
        		.win(false)
        		.currency(Currency.HUF)
        		.player(user2)
          		.odd(outcomeOdd_2)
        		.build();
        Wager w3 =  new WagerBuilder(BigDecimal.valueOf(1000))
        		.timestampCreated(LocalDateTime.parse("2020-01-02 13:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        		.processed(true)
        		.win(true)
        		.currency(Currency.HUF)
        		.odd(outcomeOdd_3)
        		.player(user)
        		.build();
        Wager w4 =  new WagerBuilder(BigDecimal.valueOf(20))
        		.timestampCreated(LocalDateTime.parse("2020-01-02 14:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        		.processed(false)
        		.win(false)
        		.currency(Currency.HUF)
        		.odd(outcomeOdd_4)
        		.player(user2)
        		.build();
        Wager w5 =  new WagerBuilder(BigDecimal.valueOf(15))
        		.timestampCreated(LocalDateTime.parse("2020-01-02 05:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        		.processed(false)
        		.win(false)
        		.currency(Currency.HUF)
        		.odd(outcomeOdd_2)
        		.player(user2)
        		.build();
        Wager w6 =  new WagerBuilder(BigDecimal.valueOf(100))
        		.timestampCreated(LocalDateTime.parse("2020-01-02 05:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        		.processed(false)
        		.win(false)
        		.currency(Currency.HUF)
        		.odd(outcomeOdd_1)
        		.player(user2)
        		.build();
        Wager w7 =  new WagerBuilder(BigDecimal.valueOf(10))
        		.timestampCreated(LocalDateTime.parse("2020-01-02 05:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        		.processed(true)
        		.win(true)
        		.currency(Currency.HUF)
        		.odd(outcomeOdd_3)
        		.player(user2)
        		.build();
        Wager w8 =  new WagerBuilder(BigDecimal.valueOf(500))
        		.timestampCreated(LocalDateTime.parse("2020-01-02 05:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        		.processed(true)
        		.win(false)
        		.currency(Currency.HUF)
        		.odd(outcomeOdd_4)
        		.player(user2)
        		.build();
     
        userRepository.save(user);
        userRepository.save(user2);
        
        sportEventRepository.save(se);
        betRepository.save(bet_1);
        betRepository.save(bet_2);


        outComeRepository.save(outcome_1);
        outComeRepository.save(outcome_2);
        outComeRepository.save(outcome_3);


        outComeOddRepository.save(outcomeOdd_1);
        outComeOddRepository.save(outcomeOdd_2);
        outComeOddRepository.save(outcomeOdd_3);
        outComeOddRepository.save(outcomeOdd_4);
        wagerRepository.save(w1);
        wagerRepository.save(w2);
        wagerRepository.save(w3);
        wagerRepository.save(w4);
        wagerRepository.save(w5);
        wagerRepository.save(w6);
        wagerRepository.save(w7);
        wagerRepository.save(w8);

    }

     public Boolean updatePlayer(String name,String birth, String acc, String Curr, String bal, String id) {
    	 
    	 try	{
    			String playername = name ;    
    			   LocalDate playerbirth = LocalDate.parse(birth) ;  
    			   Integer playeraccountnumber = Math.round(Float.parseFloat(acc));  
    			   Currency playerCurrency;
    			   switch(Curr) {
    			   case "HUF":
    				   playerCurrency = Currency.HUF;
    			     break;
    			   case "EUR":
    				   playerCurrency = Currency.EUR;
    			     break;
    			   default:
    				   playerCurrency = Currency.USD;
    			 }
    	     
    			 
    			    BigDecimal playerbalance = BigDecimal.valueOf(Float.parseFloat(bal)) ;   
    			    
    			    Integer Id = Integer.parseInt(id);
    			    
    			    Player player = this.findPlayer(Id);
    			    player.setName(playername);
    			    player.setBirth(playerbirth);
    			    player.setAccountNumber(playeraccountnumber);
    			    player.setCurrency(playerCurrency);
    			    player.setBalance(playerbalance);
    			    this.savePlayer(player);
    	    	 return true;
    	 }
    	 catch	(Exception e) {
    		 return false;
    		 
    	 }
    	 
    	 
    	 
     }
     
    @Autowired
    public void setRepositories(ApplicationContext context) {

        betRepository = context.getBean(BetRepository.class);
        outComeOddRepository = context.getBean(OutComeOddRepository.class);
        outComeRepository = context.getBean(OutComeRepository.class);
        resultRepository = context.getBean(ResultRepository.class);
        sportEventRepository = context.getBean(SportEventRepository.class);
        wagerRepository = context.getBean(WagerRepository.class);
        userRepository = context.getBean(UserRepository.class);



        initialize();

    }

    public User findUserByEmail(String name) {
    	User user =this.userRepository.findByEmailIs(name).get(0);
    	return user;
}
    
    public void reInitRepos()
    {
       betRepository.count();
       outComeOddRepository.count();
       outComeRepository.count();
       resultRepository.count();
       sportEventRepository.count();
       wagerRepository.count();
       userRepository.count();

    }

    public void savePlayer(Player player){
    	User user = userRepository.findById(player.getId()).get();
    	user.setPlayersparameters(player);
    	userRepository.save(user);
        
    }
    public User findPlayer(Integer id) {

        return userRepository.findById(id).get();
    }
    @Transactional
    public  List<SportEvent>  findAllSportEvents() {
        return sportEventRepository.findAll();
    }
    public Wager saveWager(Wager wager){

        return wagerRepository.save(wager);
    }
    @Transactional
    public List<Wager>findAllWagers()  {


        return  wagerRepository.findAll();
    }
    
    @Transactional
    public List<User>findAllPlayers()  {


        return  this.userRepository.findAll();
    }
    
    public String tableWagers(Integer Id){

    	int i = 0;
    	String table = "";
    	String button = "";
    	for (Wager wager : wagerRepository.findAll()) 
    	{ 
    		if(wager.getPlayer().getId() == Id) {
    			String wagerwin = "";
        		String wagerprocessed = "";
        		
        		wagerwin = wager.isWin() ? "Yes" : "No";
        		wagerprocessed = wager.isProcessed() ? "Yes" : "-";
        		
        		if(!wager.isProcessed()){
        			wagerwin = "-";
        		}
        	
        		wager.isWin();
        
        	   		
        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        		LocalDateTime dateTime = wager.getOdd().getOutcome().getBet().getEvent().getStartDate();
        		String formattedDateTime = dateTime.format(formatter); // "1986-04-08 12:30"
        		 if(!wager.isProcessed())
           	  		{
        			 button = "<button name=\"delete\" type=\"submit\" class=\"btn btn-primary\" value=\""+wager.getId()+"\">Remove</button>";
           	  		}
        		i++;
        	    table +="<tr>\n <td>"
        	    +button+"</td>\n <th>"
        		+i+"</th>\n <td>"
        	    +wager.getOdd().getOutcome().getBet().getEvent().getTitle()+" - "+formattedDateTime+"</td>\n <td>"
        	    +wager.getOdd().getOutcome().getBet().getEvent().getEventtype()+"</td>\n <td>"
        	    +wager.getOdd().getOutcome().getBet().getType()+"</td>\n <td>"
        	    +wager.getOdd().getOutcome().getDescription()+"</td>\n <td>"
        	    +"1:"+wager.getOdd().getValue()+"</td>\n <td>"
        	    +wager.getAmount()+" "+wager.getCurrency()+"</td>\n <td>"
        	    +wagerwin+"</td>\n <td>"
        	    +wagerprocessed+"</td>\n <td>"
        	    +"</tr>";
        	    
        	    button = "";
   		}
    		
    		
    	}	
    	return table;
      
    }

    public Boolean deleteWager(int id){

    	try {
    		this.wagerRepository.deleteById(id);
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}        	
      
    }

    
    private Wager randomwinner()
    {
        List<Wager> wagers = wagerRepository.findAll();
        int randomwinnerwage = r.nextInt(wagers.size());
        Wager wg = wagers.get(randomwinnerwage);
        return wg;

    }

    public void calculateResults() {
        if (wagerRepository.count()>0 && userRepository.count()>0) {
            Wager wg = randomwinner();
            ArrayList<Outcome> winneroutcomes = new ArrayList<Outcome>();
            Result r = new Result();
            for (Wager wager : findAllWagers()) {
                if (wager.getId() == wg.getId()) {
                    wager.setWin(true);
                  winneroutcomes.add(wager.getOdd().getOutcome());

                    findPlayer(0).setBalance(findPlayer(0).getBalance().add(wager.getAmount().multiply(wager.getOdd().getValue())));
                    wager.setProcessed(true);
                    saveWager(wager);
                }
            }
            r.setWinnerOutcomes(winneroutcomes);
            resultRepository.save(r);
        }
    }

}
