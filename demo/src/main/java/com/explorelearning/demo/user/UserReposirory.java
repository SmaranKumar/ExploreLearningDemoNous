package com.explorelearning.demo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserReposirory extends JpaRepository<User,Integer>{
	
	/** 
     * Method to find the existing record in DB  
     * @Param - firstName and LastName  
     * @Return - List<User> 
     */
	List<User> findByFirstNameAndLastName(String firstName, String lastName);

}
