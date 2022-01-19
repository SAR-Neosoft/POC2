package com.neosoft.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;


@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String fname;
	
	@NotNull
	private String lname;
	
	@NotNull
	@Column(unique = true)
	private String phoneNumber;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name="pid",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Project project;
}




 
	