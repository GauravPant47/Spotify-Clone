package com.AudioPlayerCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AudioPlayerCode.model.Audio;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Long> {
}
