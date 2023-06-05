package net.Spotify.service;

import java.util.List;
import java.util.Optional;

import net.Spotify.model.Audio;

public interface AudioService {
	
	Audio saveDatabases(Audio audio);
	
	List<Audio> getAllSong();
	
	Optional<Audio> getAllById(Long id);
}
