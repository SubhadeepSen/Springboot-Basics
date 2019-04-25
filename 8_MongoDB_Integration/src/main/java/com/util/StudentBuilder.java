package com.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentBuilder {

	public static List<Student> buildStudents(){
		List<Student> students = new ArrayList<Student>();
		
		Student student = new Student();
		student.setStudentId("1001");
		student.setRollNo("1");
		student.setFirstName("Subhadeep");
		student.setLastName("Sen");
		List<String> subjects = new ArrayList<String>();
		subjects.add("Math");
		subjects.add("Physics");
		subjects.add("Chemistry");
		subjects.add("Biology");
		subjects.add("English");
		student.setSubjects(subjects);
		student.setPhoneNumber("9475136482");
		student.setAge("18");
		student.setDateOfAdmission(LocalDateTime.now());
		student.setAdmissionFee(25450.00);
		student.setMonthlyFee(1570);	
		students.add(student);
		
		student = new Student();
		student.setStudentId("1002");
		student.setRollNo("2");
		student.setFirstName("Subham");
		student.setLastName("Paul");
		subjects = new ArrayList<String>();
		subjects.add("Math");
		subjects.add("Physics");
		subjects.add("Chemistry");
		subjects.add("English");
		student.setSubjects(subjects);
		student.setPhoneNumber("9374536482");
		student.setAge("17");
		student.setDateOfAdmission(LocalDateTime.now());
		student.setAdmissionFee(22630.00);
		student.setMonthlyFee(1850);	
		students.add(student);
		
		student = new Student();
		student.setStudentId("1003");
		student.setRollNo("3");
		student.setFirstName("Sumit");
		student.setLastName("Datta");
		subjects = new ArrayList<String>();
		subjects.add("Math");
		subjects.add("Physics");
		subjects.add("Chemistry");
		subjects.add("English");
		subjects.add("Computer");
		student.setSubjects(subjects);
		student.setPhoneNumber("8004697513");
		student.setAge("18");
		student.setDateOfAdmission(LocalDateTime.now());
		student.setAdmissionFee(28490);
		student.setMonthlyFee(1550);	
		students.add(student);
		
		return students;
	}
}
