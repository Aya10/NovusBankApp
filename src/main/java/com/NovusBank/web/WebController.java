package com.NovusBank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/")  
    public String Login()  {  
        return "login";  
    }   
	
	@RequestMapping("/SignUp")
	public String SignUp() {
		return "signup";
	}
	
	
}
