package com.AudioPlayerCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AudioPlayerCode.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
