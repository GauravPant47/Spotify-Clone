package com.AudioPlayerCode.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.AudioPlayerCode.model.Audio;
import com.AudioPlayerCode.model.Image;
import com.AudioPlayerCode.model.ProgressData;
import com.AudioPlayerCode.service.AudioService;
import com.AudioPlayerCode.service.ImageService;

@Controller
public class AudioController {

	@Autowired
	private AudioService audioService;

	@Autowired
	private ImageService imageService;
	
	@GetMapping("/audio")
	public String uploadFile(Model model) {
		List<Audio> audioList = audioService.getAllSong();
		model.addAttribute("audioList", audioList);
		return "index";
	}
	
	@GetMapping("/audio/upload")
	public String index(Model model) {
		List<Audio> audioList = audioService.getAllSong();
		model.addAttribute("audioList", audioList);
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
	
	@GetMapping("/audio/{id}")
	public ResponseEntity<List<Audio>> getAllSong(){
		List<Audio> audios = audioService.getAllSong();
		return ResponseEntity.ok(audios);
	}
	
	private boolean isPaused = false; // Track the paused state


	@GetMapping("/audio/{id}/play")
	public ResponseEntity<byte[]> getAudio(@PathVariable("id") Long id) {
		Optional<Audio> audioOptional = audioService.getAllById(id);
		if (audioOptional.isPresent()) {
			Audio audio = audioOptional.get();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// Start or resume playing the requested audio
			if (!isPaused) {
				return new ResponseEntity<>(audio.getAudioData(), headers, HttpStatus.OK);
			} else {
				// Resume playing the audio
				isPaused = false;
				return new ResponseEntity<>(audio.getAudioData(), headers, HttpStatus.PARTIAL_CONTENT);
			}
		}
		// Audio file not found
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
		Optional<Image> optionalImage = imageService.findById(id);
		if (optionalImage.isPresent()) {
			Image image = optionalImage.get();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG); // Modify the MediaType according to your image type
			return new ResponseEntity<>(image.getImageData(), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
