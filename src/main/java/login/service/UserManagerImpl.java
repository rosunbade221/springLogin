package login.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.domain.Users;
import login.manager.UserManager;
import login.repository.UserRepository;

@Service
public class UserManagerImpl implements UserManager{

private static Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users createUser(Users user) {
		
		logger.info("creating user!");
        user.setId(1);

		Users savedUser = userRepository.save(user);
		
		System.out.println(savedUser);
		return null;
		
	}

	@Override
	public List<Users> findAll() {
		return (List<Users>) userRepository.findAll();
	}
}
