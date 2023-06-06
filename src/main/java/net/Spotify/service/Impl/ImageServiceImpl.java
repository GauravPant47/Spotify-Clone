package net.Spotify.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.Spotify.model.Image;
import net.Spotify.repository.ImageRepository;
import net.Spotify.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Image saveInDatabase(Image image) {
		// TODO Auto-generated method stub
		return imageRepository.save(image);
	}

	@Override
	public Optional<Image> findById(Long id) {
		// TODO Auto-generated method stub
		return imageRepository.findById(id);
	}

}
