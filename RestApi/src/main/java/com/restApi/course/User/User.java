package com.restApi.course.User;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min=2,message="Name should have atleast 2 characters")
	@Column(name="name")
	private String name;
	
	@Past
	@Column(name="date_of_birth")
	private LocalDateTime dateOfBirth;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public User( int id,String name, LocalDateTime dateOfBirth) {
	
		this.id=id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	public User( String name, LocalDateTime dateOfBirth) {
		
		
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	public User() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	

}
