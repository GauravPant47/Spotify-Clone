package net.Spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.Spotify.model.Image;



@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
