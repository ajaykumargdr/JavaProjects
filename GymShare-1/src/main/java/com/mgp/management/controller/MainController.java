package com.mgp.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
	
	@GetMapping("/landing")
	public String landing() {
		return "Gymshare/landing";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "Gymshare/loginPage";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "Gymshare/register";
	}
	
	@GetMapping("/category")
	public String category() {
		return "Gymshare/category";
	}
	
	@GetMapping("/details")
	public String details() {
		return "Gymshare/details";
	}

	@GetMapping("/bookingpage")
	public String bookingpage() {
		return "Gymshare/bookingpage";
	}
	
	@GetMapping("/about")
	public String about() {
		return "Gymshare/about";
	}	
}
