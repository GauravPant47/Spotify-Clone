package net.Spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.Spotify.model.AudioFile;
@Repository
public interface AudioFileRepository extends JpaRepository<AudioFile, String>{

}
