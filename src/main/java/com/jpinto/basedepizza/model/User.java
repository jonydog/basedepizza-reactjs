package com.jpinto.basedepizza.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "por_user")
public class User implements Serializable {
	private static final long serialVersionUID = 270990445985081124L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 255)
	private String username;

	@NotNull
	@Size(max = 255)
	private String password;

	@NotNull
	@Size(max = 255)
	private String email;

	@Size(max = 255)
	private String phone;
	
	public User(){
		
	}

	public User(String username, String email, String phone, String password) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

}
