package com.eci.ekm.dataobject;

import org.mongodb.morphia.annotations.Entity;

@Entity(value="eci_users")
public class User extends BaseEntity{
	
	public enum Gender {
		Male,
		Female;
	}
	
	private String firstName;
	private String lastName;
	private Gender gender;
	
	public User(){
		super();
	}
	
	public User(String firstName, String lastName,Gender gender){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		System.out.println("here");
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + "]";
	}
	
	
}
