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

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	       model.addAttribute("player",player);

	       List<Currency> currencies = new ArrayList<Currency>();
	       
	       currencies.add(Currency.HUF);
	       currencies.add(Currency.EUR);
	       currencies.add(Currency.USD);
	       
	       model.addAttribute("wagers",service.TableWagers());
	       model.addAttribute("currencies",currencies);

	    
	       
	       result.addAllObjects(model.asMap());
	       result.setViewName("welcome");
	        return result;
	    }
	  @RequestMapping(value="/add", method = RequestMethod.POST)
	  public void AddedData(HttpServletRequest request,HttpServletResponse response )
	  { String url="welcome";
		  if(!this.service.updatePlayer(request.getParameter("inputname")
				  ,request.getParameter("inputbirth")
				  , request.getParameter("inputaccountnumber")
				  , request.getParameter("inputcurrency")
				  , request.getParameter("inputbalance")))
			  
		  {
			  
			  url= "notwelcome";
		  }
			 
		    try {
				response.sendRedirect(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		 
		
	  }
	  
	  @RequestMapping(value="/delete", method = RequestMethod.POST)
	  public void DeleteData(HttpServletRequest request,HttpServletResponse response )
	  { String url="welcome";
		 
			  
			
			 
		    try {
		    	String pa = request.getParameter("delete");
		    	this.service.DeleteWager(Integer.parseInt(pa));
				response.sendRedirect(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		 
		
	  }
	  

}		



