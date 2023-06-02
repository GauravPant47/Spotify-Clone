package net.Spotify.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import net.Spotify.model.Account;
import net.Spotify.service.AccountService;



@Component("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Account> optionalAccount = accountService.findOneByEmail(email);
		if (!optionalAccount.isPresent()) {
			throw new UsernameNotFoundException("Account not found");
		}
		Account account = optionalAccount.get();
		List<GrantedAuthority> grantedAuthorities = account.getAuthorities().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(),
				grantedAuthorities); // (2)
	}
}
