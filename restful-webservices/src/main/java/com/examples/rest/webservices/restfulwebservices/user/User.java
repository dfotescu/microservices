package com.examples.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.examples.rest.webservices.restfulwebservices.user.post.Post;

@Entity
public class User {
	
	@Positive
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2, message = "Name size should be at least 2")
	private String name;
	
	@Past
	private LocalDate birthDate;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Post> posts;
	
	public User() {
		super();
	}

	public User(Integer id, String name, LocalDate birthDate, ArrayList<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.posts = posts;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", posts=" + posts + "]";
	}
}
