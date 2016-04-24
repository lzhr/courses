package com.cjw.curricula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String dologin(@RequestParam("id")int id,@RequestParam("name")String name,
			@RequestParam("pw")String pw,@RequestParam("usertype")String type,
			Model model){
		
			return "redirect:/"+type+"/"+id;
	}
	
	@RequestMapping(value={"/admin","teacher","/student","/course"},
			method=RequestMethod.GET)
	public String re(){
		
		return "redirect:/login";
	}
}
