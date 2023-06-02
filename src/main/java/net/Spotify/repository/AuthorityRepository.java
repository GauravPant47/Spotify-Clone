package net.Spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.Spotify.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {}
