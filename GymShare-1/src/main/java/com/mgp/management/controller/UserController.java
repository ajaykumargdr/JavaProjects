package com.mgp.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import java.util.*;

import com.mgp.management.model.Customer;
import com.mgp.management.model.User;
import com.mgp.management.service.CustomerService;
import com.mgp.management.service.UserService;

@Controller
public class UserController {
	
	private UserService userService; // user repo
	private User currentUser; // crnt session user
	private CustomerService customerService; // customer repo 
	
	public UserController(UserService userService, CustomerService customerService) {
		super();
		this.userService = userService;
		this.customerService = customerService;
		currentUser = null;
	}
	
	@GetMapping("/login")
	public String login(User user) {
		
		if(user.getPassword() == null) return "Gymshare/loginPage";
	 
		
			User model = userService.getUser(user);
			
			if(model == null || !model.getPassword().equals(user.getPassword())) {
				System.out.println("UserName or Password error "+user.getUserId()+" "+user.getPassword());
				return "Gymshare/loginPage";
			}
			
			currentUser = model;
			
			
			return "Gymshare/landing";
	}

	@GetMapping("/registerNewUser")
	public ModelAndView registerNewUser(@RequestParam("conform-password")String cpwd, User user) {

	
			User model = userService.getUser(user);
			
			if(model == null) {
				userService.saveUser(user);
				model = user;
			}

			ModelAndView mdv = new ModelAndView("Gymshare/landing");
			mdv.addObject(model);
			
			// sent message " User already exist" && go to the login page
			if(model !=  null) { 
			return mdv; 
			} 			
			
			if(! cpwd.equals(user.getPassword()) )  {
				
					System.out.println("Password does not match! "+ user.getPassword() +" "+ cpwd ); 
				
					return mdv; 				
				}
			
			userService.saveUser(user); 
	
				
			return mdv;
	}

	@GetMapping("bookUser")
	public String bookUser(Customer customer) {
		
		if(currentUser == null) return "Gymshare/login";
		
		// else
		customer.setUserId(currentUser.getUserId());
		customer.setPhone(currentUser.getPhone());
		customer.setName(currentUser.getName());

		customerService.saveCustomer(customer);
		
		return "Gymshare/landing";
	}
	
	@GetMapping("/bookedList")
	public String getBookedList(Model model){
		
		model.addAttribute("customersList",customerService.getAllCustomers());		
		return "Gymshare/BookedList";
	}
	
	



	/////////////////////////////////////////////////////////////////////////////////////////////////

	
}
