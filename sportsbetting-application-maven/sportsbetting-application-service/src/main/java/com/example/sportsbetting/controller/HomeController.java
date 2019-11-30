package com.example.sportsbetting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.builder.SportEventBuilder;
import com.example.sportsbetting.domain.SportEvent;

import java.util.Locale;

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
	  
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br>"+service.findAllSportEvents().get(0).getTitle()+"<br>";
		return new ModelAndView("welcome", "message", message);
	}
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
