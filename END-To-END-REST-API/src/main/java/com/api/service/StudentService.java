package com.api.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Student;
import com.api.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	@PostConstruct
	public void initStudentDatabase() {
		List<Student> students = Arrays.asList(
				new Student(0, "Sunny", "Sen", "4125478469", "ABC"),
				new Student(0, "John", "Dao", "4758961245", "KGF"),
				new Student(9, "Kiara", "Snow", "9457613546", "BCK"),
				new Student(0, "Asif", "Aslam", "7548613548", "NEW"),
				new Student(0, "Tom", "Harry", "3564125879", "APN")
				);
		repository.saveAll(students);
	}

	public List<Student> getAllStudents() {
		return (List<Student>) repository.findAll();
	}
}
