package net.Spotify.service;


import org.springframework.web.multipart.MultipartFile;

import net.Spotify.model.FilesInDatabases;



public interface FileDatabasesService {

	FilesInDatabases storeFile(MultipartFile file);
	FilesInDatabases getFile(String fileId);
}
