package com.AudioPlayerCode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AudioPlayerCode.model.Audio;
import com.AudioPlayerCode.repository.AudioRepository;
import com.AudioPlayerCode.service.AudioService;

@Service
public class AudioServiceImpl implements AudioService {

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

	// Simulated audio data
	private int currentTime = 0;
	private int duration = 0;
	private Long currentAudioId = null;

	@Override
	public int getCurrentTime() {
		// TODO Auto-generated method stub
		return currentTime;
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return duration;
	}

	@Override
	public boolean switchAudioFile(Long id) {
		// TODO Auto-generated method stub
		Audio newAudio = retrieveAudioById(id);
		if (newAudio != null) {
			// Update the current audio and reset playback
			currentAudioId = id;
			currentTime = 0;
			duration = calculateDuration(newAudio);
			return true;
		}
		return false;
	}

	public Audio retrieveAudioById(Long id) {
		Optional<Audio> audioOptional = audioRepository.findById(id);
		return audioOptional.orElse(null);
	}

	private int calculateDuration(Audio audio) {
		return audio.getDurationInSeconds();
	}

}