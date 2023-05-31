package net.Spotify.service;

import org.springframework.web.multipart.MultipartFile;


import net.Spotify.model.FilesInDatabases;

public interface FileDatabasesService {
	
	FilesInDatabases getFile(String fileId);
	
	FilesInDatabases storeFile(MultipartFile file);
}
