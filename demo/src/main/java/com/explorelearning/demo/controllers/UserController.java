package com.explorelearning.demo.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.explorelearning.demo.UserApplication;
import com.explorelearning.demo.exception.UserNotFoundException;
import com.explorelearning.demo.user.User;
import com.explorelearning.demo.user.UserReposirory;

@RestController
public class UserController {	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserApplication.class);

	
	@Autowired
	private UserReposirory userRepo;
	
	/** 
     * Getting All the users, sorted ascending by lastname
     * @param - None
     * @return - List<User> 
     */
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		LOGGER.info("Returning All the Users");
		return userRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
	}

	/** 
     * Getting a specific user
     * @param - id
     * @return - User 
     */
	@GetMapping(path="/users/{id}")
	public Optional<User> getSpecificUser(@PathVariable int id){
		LOGGER.info("Retriving User:"+id);
		Optional<User> user = userRepo.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException("User-" + id + " Not Found");
		return user;
	}
	
	
	/** 
     * Adding a new user
     * @param - User object
     * @return - User Object
     */
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		LOGGER.info("Adding a new User: FirstName-" + user.getFirstName());
		
		List<User> existingUser = userRepo.findByFirstNameAndLastName(user.getFirstName(), user.getLastName());
		
		LOGGER.info("existingUser.size()-"+existingUser.size());

		if(existingUser.size() == 0 ) {
		User savedUser = userRepo.save(user);
		
		return new ResponseEntity < User > (savedUser, HttpStatus.OK);
		}
		
		LOGGER.info("Already existing User.Error.");
		return new ResponseEntity < User > (user, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

	/** 
     * Deleting a specific user
     * @param - id
     * @return - None 
     */
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id){
		  LOGGER.info("Retriving User:"+id);	
		  userRepo.deleteById(id);		
	}

	
}
