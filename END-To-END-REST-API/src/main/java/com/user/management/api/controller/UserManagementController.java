package com.user.management.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.api.model.UserDetails;
import com.user.management.api.service.UserManagementService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/*
 * The @@RestController annotation creates a rest controller and @Autowired annotation helps spring to inject a bean into that field, 
 * if present inside spring container.
 * 
 * The @RequestMapping annotation helps to map request to the given method by handler name which nothing but the path URL and type of HTTP Operation.
 */

@RestController
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;

	@ApiOperation("Get All User Details")
	@ApiImplicitParams(@ApiImplicitParam(name = "Authorization", paramType = "header", required = true))
	@RequestMapping(value = "/userdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDetails> getAllStudents() {
		return userManagementService.getAllStudents();
	}
}
