package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String user);
}
