package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.security.UserRole;


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
