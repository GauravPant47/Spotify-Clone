package net.Spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.Spotify.model.Song;

public interface SongRepository extends JpaRepository<Song, Long> {
}
