package com.AudioPlayerCode.service;


import java.util.List;
import java.util.Optional;

import com.AudioPlayerCode.model.Image;



public interface ImageService {
	
	Image saveInDatabase(Image image);
	
	Optional<Image> findById(Long id);
	
}
