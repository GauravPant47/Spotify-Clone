package net.Spotify.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import net.Spotify.model.Account;
import net.Spotify.model.Authority;
import net.Spotify.repository.AuthorityRepository;
import net.Spotify.service.AccountService;



public class SeedData implements CommandLineRunner{


	    @Autowired
	    private AccountService accountService;

	    @Autowired
	    private AuthorityRepository authorityRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		   Authority user = new Authority();
           user.setName("ROLE_USER");
           authorityRepository.save(user);

           Authority admin = new Authority();
           admin.setName("ROLE_ADMIN");
           authorityRepository.save(admin);

           Account account1 = new Account();
           Account account2 = new Account();

           account1.setFullName("user_first");
           account1.setEmail("user.user@domain.com");
           account1.setPassword("password");
           Set<Authority> authorities1 = new HashSet<>();
           authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
           account1.setAuthorities(authorities1);


           account2.setFullName("admin_first");
           account2.setEmail("admin.admin@domain.com");
           account2.setPassword("password");

           Set<Authority> authorities2 = new HashSet<>();
           authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
           authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
           account2.setAuthorities(authorities2);

           accountService.save(account1);
           accountService.save(account2);

	}
	

}
