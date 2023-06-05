package com.mgp.management.controller.india;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndiaController {
	
	@GetMapping("/kl")
	public String kl() {
		return "Gymshare/kl";
	}
	
	@GetMapping("/tn")
	public String tn() {
		return "Gymshare/tn";
	}
	
}
