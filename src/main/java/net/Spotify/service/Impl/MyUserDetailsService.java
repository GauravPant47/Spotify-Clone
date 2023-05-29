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

import net.Spotify.model.User;
import net.Spotify.service.UserService;

public class MyUserDetailsService implements UserDetailsService{

	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		  Optional<User> optionalAccount = userService.findByEmail(email);
	        if (!optionalAccount.isPresent()) {
	            throw new UsernameNotFoundException("Account not found");
	        }
	        User user = optionalAccount.get();
	        List<GrantedAuthority> grantedAuthorities = user
	                .getRole()
	                .stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());

	        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities); // (2)

	}

}
