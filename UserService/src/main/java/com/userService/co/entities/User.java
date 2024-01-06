package com.userService.co.entities;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.annotations.Table;


///import jakarta.persistence.Table;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "micro_user")

public class User {

	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public User(String user_ID, String name, String email, String about, List<Rating> ratings) {
		super();
		this.user_ID = user_ID;
		this.name = name;
		this.email = email;
		this.about = about;
		this.ratings = ratings;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Id
	@Column(name = "ID")
	private String user_ID;

	@Column(name = "NAME", length = 20)
	private String name;

	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Rating> ratings=new ArrayList<>();

}
