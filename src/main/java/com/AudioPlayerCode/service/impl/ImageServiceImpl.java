package com.AudioPlayerCode.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AudioPlayerCode.model.Image;
import com.AudioPlayerCode.repository.ImageRepository;
import com.AudioPlayerCode.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;


	@Override
	public Optional<Image> findById(Long id) {
		// TODO Auto-generated method stub
		return imageRepository.findById(id);
	}

	@Override
	public Image saveInDatabase(Image image) {
		// TODO Auto-generated method stub
		return imageRepository.save(image);
	}
}
