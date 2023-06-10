package com.AudioPlayerCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AudioPlayerCode.model.Song;
@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}

