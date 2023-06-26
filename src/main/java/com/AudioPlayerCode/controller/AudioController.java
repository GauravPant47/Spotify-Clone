package com.AudioPlayerCode.controller;

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

import com.AudioPlayerCode.model.Audio;
import com.AudioPlayerCode.model.Image;
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
