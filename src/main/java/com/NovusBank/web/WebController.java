package com.NovusBank.web;

import java.util.ArrayList;
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
	public String form(@ModelAttribute("userForm") User user, Model model) {
		dbc.addUser(user);
		User userTemp = dbc.getUser(user.getEmail());
		
		
//		Account[] accArray = (Account[]) userTemp.getAccounts();
/*		Set set = userTemp.getAccounts();
		Iterator<Account> itr = userTemp.getAccounts().iterator();
		
		long[] accountNumber = new long[set.size()];
		int[] accountBalance = new int[set.size()];

		int i=0;
		while(itr.hasNext()) {
			Account tempAcc = itr.next();
			
			accountNumber[i] = tempAcc.getAccountNumber();
			accountBalance[i] = tempAcc.getBalance();
			i++;
		}		
		
		model.addAttribute("accountNum", accountNumber);
		model.addAttribute("accountBal", accountBalance);
		*/
		
		//could find length and set modelAtt ("length", .length)
		//add all values as separate var to modelAtt. ("accNum" + i, accountNumber[i])
		int length = userTemp.getAccounts().size();
		model.addAttribute("lengthAcc", length);
		
		Set set = userTemp.getAccounts();
		Iterator<Account> itr = userTemp.getAccounts().iterator();
		
		int i=0;
		while(itr.hasNext()) {
			Account tempAcc = itr.next();
			
			model.addAttribute("accNum" + i, tempAcc.getAccountNumber());
			model.addAttribute("accBal" + i, tempAcc.getBalance());
			
			i++;
		}	
		
		
		
		return "homepage";
	}
	
	
	@RequestMapping("/login")  
    public String LoginSubmitted(@ModelAttribute("userLogin") User user, Model model)  {  
		User userTemp = dbc.getUser(user.getEmail());
		
		int length = userTemp.getAccounts().size();
		model.addAttribute("lengthAcc", length);
		
		Set set = userTemp.getAccounts();
		Iterator<Account> itr = userTemp.getAccounts().iterator();
		
		int i=0;
		while(itr.hasNext()) {
			Account tempAcc = itr.next();
			
			model.addAttribute("accNum" + i, tempAcc.getAccountNumber());
			model.addAttribute("accBal" + i, tempAcc.getBalance());
			
			i++;
		}	
		
		
		
		return "homepage";
    }   
	
	@RequestMapping("/test")  
    public String getDatabase(Model model)  {  
		
		dbc.newAccount("alexjquigley@hotmail.com");
		
		User user = dbc.getUser("alexjquigley@hotmail.com");
		
		Set<Account> accounts = user.getAccounts();
		
		Iterator<Account> it = accounts.iterator();
		
		Account account = (Account)it.next();
		
		account = (Account)it.next();

		model.addAttribute("userLogin", new User());
        return "login";  
    }   
	
	
}
