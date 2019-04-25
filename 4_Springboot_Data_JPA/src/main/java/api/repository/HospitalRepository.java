package api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.model.Hospital;

//@Repository:	defines a repository
//One can create a Repository by extending the CrudRepository interface and also avail the method of this repository to perform query 
//For creating the bean of this repository, one configuration file is required. Check api.config package for JPA configuration

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer>{

}
