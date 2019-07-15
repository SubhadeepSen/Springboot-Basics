package com.api.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Student;
import com.api.repository.StudentRepository;

/*
 * The @Service annotation creates a service bean and @Autowired annotation helps spring to inject a bean into that field, 
 * if present inside spring container.
 */

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> getAllStudents() {
		return (List<Student>) repository.findAll();
	}

	@PostConstruct
	public void initStudentDatabase() {
		/*
		 * Address addr = null; Student std = null; List<Student> students = new
		 * ArrayList<>(); addr = new Address(-1, "Gachibowli", "", "Hyderabad",
		 * "Telangana", "India", "500032"); std = new Student(0, "Sunny", "Sen",
		 * "4125478469", "ABC", addr); students.add(std);
		 * 
		 * addr = new Address(-1, "Lake View", "", "New York", "New York", "USA",
		 * "10001"); std = new Student(0, "John", "Dao", "4758961245", "XYZ", addr);
		 * students.add(std);
		 * 
		 * addr = new Address(-1, "Runy", "", "Kolkata", "West Bengal", "India",
		 * "700107"); std = new Student(0, "Asif", "Aslam", "7548613548", "APN", addr);
		 * students.add(std); repository.saveAll(students);
		 */
	}
}
