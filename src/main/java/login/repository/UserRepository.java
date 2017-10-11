package login.repository;

import org.springframework.data.repository.CrudRepository;

import login.domain.Users;

public interface UserRepository extends CrudRepository<Users, Long> {

}
