package com.AudioPlayerCode.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.AudioPlayerCode.service.AudioService;

@Controller
public class ListOfSongs {

	@Autowired
	private AudioService audioService;

	@GetMapping("/audio/listSong")
	public String songlist() {
		return "listOfSongs";
	}
	
}
