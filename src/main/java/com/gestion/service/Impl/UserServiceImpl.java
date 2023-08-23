package com.gestion.service.Impl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.domain.User;
import com.gestion.domain.security.UserRole;
import com.gestion.service.UserService;
import com.gestion.Repository.RoleRepository;
import com.gestion.Repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User localUser = userRepository.findByUsername(user.getUsername());

		if (localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);

			localUser = userRepository.save(user);
		}

		return localUser;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public User findBydId(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
	

	

}
