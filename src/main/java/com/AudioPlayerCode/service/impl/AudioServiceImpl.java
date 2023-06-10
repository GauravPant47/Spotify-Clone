//package com.AudioPlayerCode.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.AudioPlayerCode.model.Audio;
//import com.AudioPlayerCode.repository.AudioRepository;
//import com.AudioPlayerCode.service.AudioService;
//
//@Service
//public class AudioServiceImpl implements AudioService{
//	
//	@Autowired
//	private AudioRepository audioRepository;
//	
//	@Override
//	public Audio saveDatabases(Audio audio) {
//		// TODO Auto-generated method stub
//		return audioRepository.save(audio);
//	}
//
//	@Override
//	public List<Audio> getAllSong() {
//		// TODO Auto-generated method stub
//		return audioRepository.findAll();
//	}
//
//	@Override
//	public Optional<Audio> getAllById(Long id) {
//		// TODO Auto-generated method stub
//		return audioRepository.findById(id);
//	}
//
//}