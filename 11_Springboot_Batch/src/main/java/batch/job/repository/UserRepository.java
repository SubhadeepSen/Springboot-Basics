package batch.job.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import batch.job.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
