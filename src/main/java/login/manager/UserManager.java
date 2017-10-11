package login.manager;

import java.util.List;

import login.domain.Users;

public interface UserManager {

	public Users createUser(Users user);
	
	public List<Users> findAll();
}
