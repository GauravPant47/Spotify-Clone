package com.AudioPlayerCode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.AudioPlayerCode.model.Audio;
import com.AudioPlayerCode.service.AudioService;


@Controller
public class ListOfSongs {
	
	@Autowired
	private AudioService audioService;
	
	@GetMapping("/listSong")
	public String songlist(Model model) {
		List<Audio> audioList = audioService.getAllSong();
		model.addAttribute("audioList", audioList);
		return "listOfSongs";
	}
}
