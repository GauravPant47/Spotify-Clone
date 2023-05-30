package net.Spotify.service;

import org.springframework.web.multipart.MultipartFile;

import net.Spotify.model.AudioFile;

public interface AudioFileService {
	
	AudioFile getFile(String fileId);
	
	AudioFile storeFile(MultipartFile file);
}
