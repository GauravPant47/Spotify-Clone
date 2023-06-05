package net.Spotify.service;

import java.util.Optional;

import net.Spotify.model.Image;

public interface ImageService {
	
	Image saveInDatabase(Image image);
	
	Optional<Image> findById(Long id);
	
}
