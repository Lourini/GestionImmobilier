package com.gestion.service;

import java.util.List;
import java.util.Set;

import com.gestion.domain.User;
import com.gestion.domain.security.UserRole;

public interface UserService {
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
	
	List<User> findAll();
	
	User findBydId(Long id);
	
	void deleteUserById(Long id);

}
