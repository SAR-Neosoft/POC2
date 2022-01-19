package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{
	
	

}
