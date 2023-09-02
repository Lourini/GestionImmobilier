package com.gestion.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.Repository.RoleRepository;
import com.gestion.domain.security.Role;
import com.gestion.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		return roleRepository.findById(id);
	}

	@Override
	public void addRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void updateRole(Long id, Role role) {
		roleRepository.save(role);
	}

	@Override
	public void deleteById(Long id) {
		roleRepository.deleteById(id);
	}

}
