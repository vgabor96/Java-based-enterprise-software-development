package com.example.sportsbetting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.builder.SportEventBuilder;
import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.converter.ResourceHttpMessageConverter;

@Controller
public class HomeController {
	
	
	@Autowired
	private SportsBettingService service;

	  @GetMapping("/")
	    public String homeInit(Locale locale, Model model) {
	        return "home";
	    }
	  

	  
	  @RequestMapping(value = "/welcome", method = RequestMethod.GET )
	    public ModelAndView ShowData(Model model) {
	      
	       ModelAndView result = new ModelAndView();
	       
	       Player player = service.findPlayer();
	       Currency currency = Currency.EUR;
	       currency = player.getCurrency();
	     
	       model.addAttribute("name", player.getName());
	       model.addAttribute("birth", player.getBirth());
	       model.addAttribute("balance", player.getBalance());
	       model.addAttribute("currency", currency);
	       model.addAttribute("accountnumber", player.getAccountNumber());
	       
	       model.addAttribute("wagers",service.TableWagers());
	      

	       model.addAttribute("currencies", Currency.values());
	       
	       result.addAllObjects(model.asMap());
	       result.setViewName("welcome");
	        return result;
	    }
	  /*
	   *    <c:forEach items="${wagers}" var="wager">
    <tr>
      <td><c:out value="${wager.getEventTitle()}" /></td>
    </tr>
  </c:forEach>
	   * 
	   * 	  @RequestMapping(value = "/welcome", method = RequestMethod.GET )
	    public String submit(@Valid @ModelAttribute("player")Player player, 
	      BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "error";
	        }
	        model.addAttribute("name", player.getName());
	        model.addAttribute("birth", player.getBirth());
	        model.addAttribute("balance", player.getBalance());
	        model.addAttribute("currency", player.getCurrency());
	        model.addAttribute("accountnumber", player.getAccountNumber());

	        return "welcome";
	    }
	   * 
	  @RequestMapping("/welcome")
	  public String listJobs(Map<String,Object> map){
	      map.put("wager", new Wager());
	      map.put("wagerList", service.findAllWagers());
	      return "welcome";
	  }*/
	  /*
	  	@RequestMapping("/welcome")
		public String printWelcome(ModelMap model) {
	 
	  		Player player = service.findPlayer();
		
			// you can add any Collection Objects to ModelMap
			// including JSON, String, Array, Map, List, etc...
	  		String name = player.getName();
	  		String birth = player.getBirth().toString();
	  		String accountnumber = player.getAccountNumber().toString();
	  		String currency = player.getCurrency().toString();
	  		String balance = player.getBalance().toString();
			model.addAttribute("name", name);
			model.addAttribute("birth", birth);
			model.addAttribute("accountnumber", accountnumber);
			model.addAttribute("currency", currency);
			model.addAttribute("balance", balance);
			return "welcome";
		}*/
	  /*
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		ModelAndView result;
		Player player;
		player = service.findPlayer();
		 result = new ModelAndView("welcome");
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			result.addObject("player", objectMapper.writeValueAsString(player));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String message = "<br>"+service.findAllSportEvents().get(0).getTitle()+"<br>";
		return result;
	}
	*/
/*
	  
		public SportEvent BetWorld() {
			SportEvent event = new SportEventBuilder("firstevent").build();
			return event ;
		}
		
	  
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", eventTransformer());
	}
	
	public String eventTransformer() {
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>"+BetWorld().getTitle() +"</div><br><br>";
		return message;
	}
*/
}
