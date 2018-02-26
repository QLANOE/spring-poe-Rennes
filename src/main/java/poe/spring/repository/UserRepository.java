package poe.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.spring.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByLogin(String login);

}
