package com.prageet.adminportal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;
    private ApplicationUserRepository applicationUserRepository;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserController(ApplicationUserRepository applicationUserRepository,
	    BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.applicationUserRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

    @PostMapping("/signup")
    public ApplicationUser create(@RequestBody ApplicationUser user){
    	user.setCreationDate(getCurrentTime());
    	user.setLastModifiedDate(getCurrentTime());
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return applicationUserRepository.save(user);
    }

    @GetMapping(path = {"/{id}"})
    public ApplicationUser findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public ApplicationUser update(@PathVariable("id") int id, @RequestBody ApplicationUser user){
        user.setId(id);
    	user.setLastModifiedDate(getCurrentTime());
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public ApplicationUser delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<ApplicationUser> findAll(){
        return userService.findAll();
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public void logoutPage (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        response.sendRedirect("/login");
    }
    
    public Date getCurrentTime() {
    	//Getting the current timestamp
    	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());       
        return timestamp;    	
    }
}
