package net.Spotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.Spotify.model.User;
import net.Spotify.service.UserService;

@Controller
public class RegistraController {
	
	@Autowired
	private UserService userService;
	
	
	
	// TODO:  this will help us create a new account using registration form 
	@GetMapping("/registra")
	public String getRegistraPage(Model model)
	{
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "registra";
	}
	
	// TODO: This will help us to update new account data in databases
	@PostMapping("/registra")
	public String newAccountCreation(@ModelAttribute User user)
	{
		userService.savedata(user);
		return "redirect:/index";
	}
	
}
