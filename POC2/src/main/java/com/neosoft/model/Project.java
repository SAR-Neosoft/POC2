package com.neosoft.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	
	
	@NotNull
	@Size(max=65)
	private String pname;
	
	@NotNull
	@Size(max=65)
	private String duration;
	
	
}
