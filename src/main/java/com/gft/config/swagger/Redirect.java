package com.gft.config.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Redirect {
	
	@GetMapping("/")
	public String rd() {
		return "redirect:/swagger-ui.html";
	}


}
