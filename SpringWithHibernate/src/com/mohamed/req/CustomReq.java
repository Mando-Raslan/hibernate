package com.mohamed.req;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.mohamed.entity.Detail;
import com.mohamed.entity.RequestCustom;
import com.mohamed.validation.CustomValidation;


public class CustomReq {
	
	
	private Integer id;
	
	@NotNull(message = "firstName required")
	private String firstName;
	
	@NotNull(message = "lastName required")
	private String lastName;
	
	@NotNull(message        = "email required")
	@CustomValidation(value = {"@yahoo.com" , "@gmail.com" ,"@outlook.com"} , message = "must end with @...")
	private String email;
	
	@NotNull(message = "gender required")
	private String gender;
	
	@NotNull(message = "age required")
	private Integer age;
	
	
	private Detail detailcustomer;
	
	
	String [] genderlist;

	
	private List<RequestCustom> requests;
	
	public List<RequestCustom> getRequests() {
		return requests;
	}

	public void setRequests(List<RequestCustom> requests) {
		this.requests = requests;
	}

	public String[] getGenderlist() {
		return genderlist;
	}

	public void setGenderlist(String[] genderlist) {
		this.genderlist = genderlist;
	}

	public CustomReq() {
		
		genderlist = new String[2];
		
		genderlist[0] = "male";
		genderlist[1] = "female";
	}

	public CustomReq(String firstName, String lastName, String email, String gender, Integer age) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Detail getDetailcustomer() {
		return detailcustomer;
	}

	public void setDetailcustomer(Detail detailcustomer) {
		this.detailcustomer = detailcustomer;
	}

	
}
