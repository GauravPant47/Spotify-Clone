package net.Spotify.service;

import java.util.Optional;

import net.Spotify.model.User;

public interface UserService {
	User savedata(User user);

	Optional<User> findByEmail(String email);
}
