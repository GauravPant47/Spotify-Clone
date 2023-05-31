package net.Spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.Spotify.model.FileModel;

@Repository
public interface FileRepository extends JpaRepository<FileModel, Long>{

}
