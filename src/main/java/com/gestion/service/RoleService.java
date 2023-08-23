package com.gestion.service;

import java.util.List;
import java.util.Optional;

import com.gestion.domain.security.Role;

public interface RoleService {
	
	List<Role> findAll();
	
	Optional<Role> findById(Long id);
	
	void addRole(Role role);
	
	void updateRole(Long id, Role role);
	
	void deleteById(Long id);
}
