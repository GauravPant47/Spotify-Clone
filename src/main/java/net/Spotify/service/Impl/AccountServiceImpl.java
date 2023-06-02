package net.Spotify.service.Impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.Spotify.model.Account;
import net.Spotify.model.Authority;
import net.Spotify.repository.AccountRepository;
import net.Spotify.repository.AuthorityRepository;
import net.Spotify.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	public Account save(Account account) {

		if (account.getId() == null) {
			if (account.getAuthorities().isEmpty()) {
				Set<Authority> authorities = new HashSet<>();
				authorityRepository.findById("ROLE_USER").ifPresent(authorities::add);
				account.setAuthorities(authorities);
			}
		}

		account.setPassword(passwordEncoder.encode(account.getPassword()));
		return accountRepository.save(account);
	}

	public Optional<Account> findOneByEmail(String email) {
		return accountRepository.findOneByEmailIgnoreCase(email);
	}
}
