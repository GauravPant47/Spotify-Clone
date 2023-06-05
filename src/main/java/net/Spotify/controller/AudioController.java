package net.Spotify.controller;


import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.Spotify.model.Audio;
import net.Spotify.model.Image;
import net.Spotify.repository.AudioRepository;
import net.Spotify.repository.ImageRepository;

@Controller
public class AudioController {
	@Autowired
	private AudioRepository audioRepository;
	
	 @Autowired
	 private ImageRepository imageRepository;
	
	@PostMapping("/index/upload")
    public String upload(@RequestParam("audio") MultipartFile audioFile,
            @RequestParam("image") MultipartFile imageFile,
            @RequestParam("title") String title) throws IOException {
        Audio audio = new Audio();
        audio.setTitle(title);
        audio.setAudioData(audioFile.getBytes());
        audioRepository.save(audio);

        // Save the image file
        Image image = new Image();
        image.setTitle(title);
        image.setImageData(imageFile.getBytes());
        imageRepository.save(image);

        return "redirect:/index/upload";
    }
	
	 @GetMapping("/audio/{id}")
	    public ResponseEntity<byte[]> getAudio(@PathVariable("id") Long id) {
	        Optional<Audio> audioOptional = audioRepository.findById(id);
	        if (audioOptional.isPresent()) {
	            Audio audio = audioOptional.get();
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	            return new ResponseEntity<>(audio.getAudioData(), headers, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    // Other methods
	    @GetMapping("/image/{id}")
	    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
	        Optional<Image> optionalImage = imageRepository.findById(id);
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
