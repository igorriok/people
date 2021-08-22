package com.example.people.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Person")
@Entity
public class Person {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "FULLNAME", nullable = false)
	private String fullName;
	
	@Getter
	@Setter
	@Column(name = "SUFFIX")
	private String suffix;
	
	@Getter
	@Setter
	@Column(name = "PHOTO_URL", nullable = false)
	private String photoUrl;
}
