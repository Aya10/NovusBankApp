package com.NovusBank.web;

import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.NovusBank.application.DatabaseController;
import com.NovusBank.entity.Account;
import com.NovusBank.entity.User;

@Controller
public class WebController {
	
	DatabaseController dbc = new DatabaseController();
	
	@RequestMapping("/")  
    public String Login(Model model)  {  
		model.addAttribute("userLogin", new User());
        return "login";  
    }   
	
	@RequestMapping("/SignUp")
	public String SignUp(Model model) {
		model.addAttribute("userForm", new User());
		return "signup";
	}
	
	@RequestMapping(value = "/registered", method=RequestMethod.POST)
	public String form(@ModelAttribute("userForm") User user) {
		dbc.addUser(user);
		return "homepage";
	}
	
	
	@RequestMapping("/login")  
    public String LoginSubmitted(@ModelAttribute("userLogin") User user)  {  
		
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
        return "homepage";  
    }   
	
	@RequestMapping("/test")  
    public String getDatabase(Model model)  {  
		
		dbc.newAccount("alexjquigley@hotmail.com");
		
		
		User user = dbc.getUser("alexjquigley@hotmail.com");
		
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		
		Set<Account> accounts = user.getAccounts();
		
		Iterator it = accounts.iterator();
		
		Account account = (Account)it.next();
		
		System.out.println(account.getAccountNumber());
		
		account = (Account)it.next();
		
		System.out.println(account.getAccountNumber());
		
		
		model.addAttribute("userLogin", new User());
        return "login";  
    }   
	
	
}
