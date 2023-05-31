package net.Spotify.service;



import net.Spotify.model.FileModel;

public interface FileDatabasesService {
	
	FileModel getFile(Long Id);
	
	FileModel saveFile(FileModel file);
}
