package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Student;
import com.api.service.StudentService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@ApiOperation("Get All Students")
	@ApiImplicitParams(@ApiImplicitParam(name = "Basic Authentication", paramType = "header", required = true))
	@RequestMapping(value = "/students", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
}
