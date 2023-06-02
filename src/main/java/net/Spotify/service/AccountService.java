package net.Spotify.service;

import java.util.Optional;

import net.Spotify.model.Account;

public interface AccountService {
	Account save(Account account);
	
	Optional<Account> findOneByEmail(String email); 
}
