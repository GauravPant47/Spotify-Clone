package net.Spotify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.Spotify.model.Audio;
import net.Spotify.service.AudioService;

@Controller
public class MainController {

	@Autowired
	private AudioService audioService;

	@GetMapping("/index")
	public String mainPage() {
		return "index";
	}

	@GetMapping("/index/upload")
	public String uploadFile(Model model) {
		List<Audio> audioList = audioService.getAllSong();
		model.addAttribute("audioList", audioList);
		return "adminpage";
	}
}
