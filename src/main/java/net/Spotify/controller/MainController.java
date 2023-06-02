package net.Spotify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/index")
	public String mainPage() {
		return "index";
	}
	
	@GetMapping("/index/upload")
	public String uploadFile() {
		return "adminpage";
	}
}
