package com.explorelearning.demo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;	
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	User(){		
	}
	
	public User(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}	
	
	/** 
     * Getter method for Id 
     * @Param - None  
     * @Return - Integer 
     */
	public Integer getId() {
		return id;
	}
	
	/** 
     * Setter method for Id  
     * @Param - Integer  
     * @Return - None 
     */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/** 
     * Getter method for firstName
     * @Param - None  
     * @Return - String 
     */
	public String getFirstName() {
		return firstName;
	}
	
	/** 
     * Setter method for firstname   
     * @Param - String  
     * @Return - None 
     */
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	/** 
     * Getter method for lastname
     * @Param - args  
     * @Return - String 
     */
	public String getLastName() {
		return lastName;
	}
	
	/** 
     * Setter method for lastname   
     * @Param - String  
     * @Return - None 
     */
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	
	/** 
     * toString method
     * @Param - None  
     * @Return - String 
     */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}	
}
