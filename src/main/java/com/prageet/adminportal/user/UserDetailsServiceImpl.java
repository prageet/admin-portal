package com.prageet.adminportal.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private ApplicationUserRepository applicationUserRepository;
	
    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
    	this.applicationUserRepository = applicationUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByEmail(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), getAuthority());
    }
    
    private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}