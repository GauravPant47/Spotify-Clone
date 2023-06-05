package net.Spotify.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import net.Spotify.model.Audio;
import net.Spotify.repository.AudioRepository;
import net.Spotify.service.AudioService;

public class AudioServiceImpl implements AudioService{
	
	@Autowired
	private AudioRepository audioRepository;
	
	@Override
	public Audio saveDatabases(Audio audio) {
		// TODO Auto-generated method stub
		return audioRepository.save(audio);
	}

	@Override
	public List<Audio> getAllSong() {
		// TODO Auto-generated method stub
		return audioRepository.findAll();
	}

	@Override
	public Optional<Audio> getAllById(Long id) {
		// TODO Auto-generated method stub
		return audioRepository.findById(id);
	}

}
