package com.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}