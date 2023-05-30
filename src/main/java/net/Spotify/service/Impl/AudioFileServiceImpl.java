package net.Spotify.service.Impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import net.Spotify.exception.FileNotFoundException;
import net.Spotify.exception.FileStorageException;
import net.Spotify.model.AudioFile;
import net.Spotify.repository.AudioFileRepository;
import net.Spotify.service.AudioFileService;

@Service
public class AudioFileServiceImpl implements AudioFileService {

	@Autowired
	private AudioFileRepository audioFileRepository;
	
	
	
	// TODO: This will help us to find the file using file id
	@Override
	public AudioFile getFile(String fileId) {

		return audioFileRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
	}

	
	// TODO: This will help us to sore the Audio Files
	@Override
	public AudioFile storeFile(MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			AudioFile files = new AudioFile(fileName, file.getContentType(), file.getBytes());
			return audioFileRepository.save(files);
		} catch (IOException e) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
		}
	}

}
