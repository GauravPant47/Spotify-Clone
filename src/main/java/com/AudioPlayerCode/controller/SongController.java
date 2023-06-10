package com.AudioPlayerCode.controller;

import org.hibernate.engine.jdbc.StreamUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.AudioPlayerCode.model.Song;
import com.AudioPlayerCode.repository.SongRepository;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SongController {

	@Autowired
	private SongRepository songRepository;

	@GetMapping("/songs")
	public String listSongs(Model model) {
		model.addAttribute("songs", songRepository.findAll());
		return "songs";
	}

	@PostMapping("/upload")
	public String uploadSong(@RequestParam("file") MultipartFile file, @ModelAttribute Song song) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		song.setFilename(fileName);
		songRepository.save(song);
		// Save the file to a directory of your choice

		return "redirect:/songs";
	}

	@GetMapping("/{id}/play")
	public ResponseEntity<Resource> playSong(@PathVariable("id") String id) {
	    Long songId;
	    try {
	        songId = Long.parseLong(id);
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Invalid song ID");
	    }

	    Song song = songRepository.findById(songId)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid song ID"));

	    // Assuming the audio files are stored in a directory named "songs" on the server
	    String filePath = "path/to/songs/" + song.getFilename();

	    try {
	        Resource resource = new UrlResource(Paths.get(filePath).toUri());

	        if (resource.exists() && resource.isReadable()) {
	            return ResponseEntity.ok()
	                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                    .body(resource);
	        } else {
	            throw new RuntimeException("Song file does not exist or is not readable.");
	        }
	    } catch (MalformedURLException e) {
	        throw new RuntimeException("Invalid file path: " + filePath);
	    }
	}

}
