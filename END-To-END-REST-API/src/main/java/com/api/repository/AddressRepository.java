package com.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Address;

/*
 * As JPA and H2 In-Memory SQL Database are used, this interface provides methods to simplify operations on the Database.
 * The @Repository annotation creates a repository bean. Here spring internally takes care of creating the bean.
 * This also works with external SQL Databases, just need to change the datasource configuration to point to external Database.
 */

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}