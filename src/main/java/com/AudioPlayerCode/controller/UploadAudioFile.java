package com.AudioPlayerCode.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.AudioPlayerCode.model.Audio;
import com.AudioPlayerCode.model.Image;
import com.AudioPlayerCode.service.AudioService;
import com.AudioPlayerCode.service.ImageService;

@Controller
public class UploadAudioFile {
	@Autowired
	private AudioService audioService;

	@Autowired
	private ImageService imageService;
	
	@GetMapping("/upload")
	public String index() {
		return "adminpage";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("audio") MultipartFile audioFile, @RequestParam("image") MultipartFile imageFile,
			@RequestParam("title") String title, @RequestParam("title") String artist) throws IOException {
		Audio audio = new Audio();
		audio.setTitle(title);
		audio.setArtist(artist);
		audio.setAudioData(audioFile.getBytes());
		audioService.saveDatabases(audio);

		// Save the image file
		Image image = new Image();
		image.setTitle(title);
		image.setArtist(artist);
		image.setImageData(imageFile.getBytes());
		imageService.saveInDatabase(image);

		return "redirect:/audio";
	}
}
