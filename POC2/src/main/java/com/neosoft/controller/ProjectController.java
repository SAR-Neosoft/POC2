package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Project;
import com.neosoft.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	 ProjectRepository projectRepository;
	
	
	
	@PostMapping("/addProjecttt")
	public ResponseEntity<?> addPro(@RequestBody Project project) {
		projectRepository.save(project);
		return new ResponseEntity<>("Inserted successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllProjectsss")
	public List<Project> getAllProject() {
		return projectRepository.findAll();
		
	}
}
