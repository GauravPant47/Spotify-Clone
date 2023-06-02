package net.Spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.Spotify.model.FilesInDatabases;



public interface FileRepository extends JpaRepository<FilesInDatabases, String>{

}
