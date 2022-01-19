package com.neosoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Project;
import com.neosoft.model.Student;
import com.neosoft.repository.ProjectRepository;
import com.neosoft.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	 ProjectRepository projectRepository;
	
	@PostMapping("/insertSt/{pid}")
	public Optional<Object> addStudent(@RequestBody Student student ,@PathVariable Long pid) {
		
		return projectRepository.findById(pid).map(proj -> {
			student.setProject(proj);
		
		
		studentRepository.save(student);
		return new ResponseEntity<>("Inserted successfully", HttpStatus.OK);
		});
	}
	
	@GetMapping("/getStBy/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id) {
		return studentRepository.findById(id);
		
	}
	@GetMapping("/getAllSt")
	public List<Student> getAllstudents() {
		return studentRepository.findAll();
		
	}
		
	
}
