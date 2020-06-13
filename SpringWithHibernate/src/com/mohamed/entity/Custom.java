package com.mohamed.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class Custom {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "AGE")
	private Integer age;
	
	@JoinColumn(name  = "DETAIL_PK")
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Detail detailcustomer;

	
	@OneToMany(mappedBy = "custom")
	private List<RequestCustom> requests;
	
	
	
	
	
	public List<RequestCustom> getRequests() {
		return requests;
	}

	public void setRequests(List<RequestCustom> requests) {
		this.requests = requests;
	}

	public Custom() {}

	public Custom(String firstName, String lastName, String email, String gender, Integer age) {
		super();
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

	
	
	public void addRequest(RequestCustom requestCustom) {
		
		if(requests == null)
			requests = new ArrayList<RequestCustom>();
		
		requests.add(requestCustom);
		
		requestCustom.setCustom(this);
		
		
	}
	
	
	            
	
}
