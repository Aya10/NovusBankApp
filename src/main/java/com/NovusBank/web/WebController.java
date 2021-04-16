package com.NovusBank.web;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.NovusBank.entity.User;

@Controller
public class WebController {
	
	Session session;
	
	@RequestMapping("/")  
    public String Login(Model model)  {  
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		  
		   StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		   
		   SessionFactory sf = con.buildSessionFactory(reg);

		   session = sf.openSession(); 
		   
        return "login";  
    }   
	
	@RequestMapping("/SignUp")
	public ModelAndView SignUp() {
		return new ModelAndView("signup", "userForm", new User());
	}
	
	@RequestMapping(value = "/formSubmitted", method=RequestMethod.POST)
	public String form(@ModelAttribute("userForm") User user) {
		
		Transaction t = session.beginTransaction(); 
		session.save(user);  
	    t.commit();
		
		return "login";
	}
	
	
	
}
