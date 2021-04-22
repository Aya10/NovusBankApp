package com.NovusBank.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping("/homepage")
	public String backToHomePage(@RequestParam(value="backToHome") String email, Model model) {
		User userTemp = dbc.getUser(email);
		int length = userTemp.getAccounts().size();
		model.addAttribute("lengthAcc", length);
		
		Iterator<Account> itr = userTemp.getAccounts().iterator();
		
		int i=0;
		while(itr.hasNext()) {
			Account tempAcc = itr.next();
			
			model.addAttribute("accNum" + i, tempAcc.getAccountNumber());
			model.addAttribute("accBal" + i, tempAcc.getBalance());
			
			i++;
		}
		model.addAttribute("user", email);
		return "homepage";
	}
	
	@RequestMapping(value = "/registered", method=RequestMethod.POST)
	public String form(@ModelAttribute("userForm") User user, Model model) {
		dbc.addUser(user);
		User userTemp = dbc.getUser(user.getEmail());
		
		int length = userTemp.getAccounts().size();
		model.addAttribute("lengthAcc", length);
		
		Iterator<Account> itr = userTemp.getAccounts().iterator();
		
		int i=0;
		while(itr.hasNext()) {
			Account tempAcc = itr.next();
			model.addAttribute("accNum" + i, tempAcc.getAccountNumber());
			model.addAttribute("accBal" + i, tempAcc.getBalance());
			
			i++;
		}
		model.addAttribute("user", userTemp.getEmail());
		return "homepage";
	}
	
	
	@RequestMapping("/login")  
    public String LoginSubmitted(@ModelAttribute("userLogin") User user, Model model)  {  
		User userTemp = dbc.getUser(user.getEmail());
		
		int length = userTemp.getAccounts().size();
		model.addAttribute("lengthAcc", length);
		
		Iterator<Account> itr = userTemp.getAccounts().iterator();
		
		int i=0;
		while(itr.hasNext()) {
			Account tempAcc = itr.next();
			
			model.addAttribute("accNum" + i, tempAcc.getAccountNumber());
			model.addAttribute("accBal" + i, tempAcc.getBalance());
			
			i++;
		}
		model.addAttribute("user", userTemp.getEmail());
		return "homepage";
    }   
	
	@RequestMapping("/transfer")  
    public String getTransfer(@RequestParam(value="button") String accountNum, Model model)  {  

		System.out.println(accountNum);
		
		Account tempAccount = dbc.getAccount(Long.parseLong(accountNum));
		
		model.addAttribute("accountNum", tempAccount.getAccountNumber());
		
		model.addAttribute("user", tempAccount.getUser().getEmail());
        return "transferpage";  
    }   
	
	@RequestMapping("/transferSubmit")  
    public String submitTransfer(@RequestParam(value="accountNum") String accountNum, @RequestParam(value="amount") String tempAmount, @RequestParam(value="accountSender") String accountSender, Model model)  {  
		
		long sender = Long.parseLong(accountSender);
		long reciever = Long.parseLong(accountNum);
		int amount = Integer.parseInt(tempAmount);
		
		if(dbc.getAccount(sender).getBalance()<amount) {
			model.addAttribute("accountNum", sender);	
			model.addAttribute("user", dbc.getAccount(sender).getUser().getEmail());
			return "transferpage";
		}
		
		Account tempReciever = new Account();
		tempReciever.setAccountNumber(reciever);
		tempReciever.setBalance(dbc.getAccount(reciever).getBalance()+amount);
		tempReciever.setUser(dbc.getAccount(reciever).getUser());
		dbc.updateAccount(tempReciever);
		
		Account tempSender = new Account();
		tempSender.setAccountNumber(sender);
		tempSender.setBalance(dbc.getAccount(sender).getBalance()-amount);
		tempSender.setUser(dbc.getAccount(sender).getUser());
		dbc.updateAccount(tempSender);
				
		User userTemp = dbc.getAccount(sender).getUser();
		int length = userTemp.getAccounts().size();
		model.addAttribute("lengthAcc", length);
		
		Iterator<Account> itr = userTemp.getAccounts().iterator();
		
		int i=0;
		while(itr.hasNext()) {
			Account tempAcc = itr.next();
			
			model.addAttribute("accNum" + i, tempAcc.getAccountNumber());
			model.addAttribute("accBal" + i, tempAcc.getBalance());
			
			i++;
		}
		model.addAttribute("user", userTemp.getEmail());
        return "homepage";  
    }   
	
	@RequestMapping("/newAccount")  
    public String test(@RequestParam(value="newAccount") String email, Model model)  {  
		dbc.newAccount(email);
		User userTemp = dbc.getUser(email);
		int length = userTemp.getAccounts().size();
		model.addAttribute("lengthAcc", length);
		
		Iterator<Account> itr = userTemp.getAccounts().iterator();
		
		int i=0;
		while(itr.hasNext()) {
			Account tempAcc = itr.next();
			
			model.addAttribute("accNum" + i, tempAcc.getAccountNumber());
			model.addAttribute("accBal" + i, tempAcc.getBalance());
			
			i++;
		}
		model.addAttribute("user", email);
        return "homepage";  

    }   
	
}
