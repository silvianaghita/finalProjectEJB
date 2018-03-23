package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@DiscriminatorColumn(name="DTYPE",
discriminatorType=DiscriminatorType.STRING)
@Inheritance(strategy=InheritanceType.JOINED)
public class PlatformUser implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String address;
	private String email;
	private String password;
	private static final long serialVersionUID = 1L;

	public PlatformUser() {
		super();
	}   
	
	
	
	public PlatformUser(String username) {
		super();
		this.username = username;
	}



	public String getPassword() {
		return password;
	}

	public PlatformUser setPassword(String password) {
		this.password = password;
		return this;
	}

	public int getId() {
		return this.id;
	}

	public PlatformUser setId(int id) {
		this.id = id;
		return this;
	}   
	public String getUsername() {
		return this.username;
	}

	public PlatformUser setUsername(String username) {
		this.username = username;
		return this;
	}   
	public String getAddress() {
		return this.address;
	}

	public PlatformUser setAddress(String address) {
		this.address = address;
		return this;
	}   
	public String getEmail() {
		return this.email;
	}

	public PlatformUser setEmail(String email) {
		this.email = email;
		return this;
	}
   
}
