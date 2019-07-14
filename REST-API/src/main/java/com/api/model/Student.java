package com.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollNo;

	//@Min(value = 2, message = "Firstname must be greater than 2 characters.")
	//@Max(value = 15, message = "Firstname must be less than or equal to 15 characters.")
	private String firstName;

	//@Min(value = 2, message = "Lastname must be greater than 2 characters.")
	//@Max(value = 15, message = "Lastname must be less than or equal to 15 characters.")
	private String lastName;

	//@Min(value = 10, message = "Phone number must be of 10 characters.")
	//@Max(value = 10, message = "Phone number must be of 10 characters.")
	private String phoneNumber;

	//@Min(value = 1, message = "Department name must be provided.")
	private String department;

}
