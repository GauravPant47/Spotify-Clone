package net.Spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.Spotify.model.Audio;



@Repository
public interface AudioRepository extends JpaRepository<Audio, Long> {
}
