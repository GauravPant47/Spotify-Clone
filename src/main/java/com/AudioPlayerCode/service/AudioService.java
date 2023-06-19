package com.AudioPlayerCode.service;

import java.util.List;
import java.util.Optional;

import com.AudioPlayerCode.model.Audio;

public interface AudioService {

	Audio saveDatabases(Audio audio);

	List<Audio> getAllSong();

	Optional<Audio> getAllById(Long id);

	int getCurrentTime();
	int getDuration();
	boolean switchAudioFile(Long id);
}