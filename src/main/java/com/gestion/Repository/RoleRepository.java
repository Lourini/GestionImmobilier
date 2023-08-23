package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.security.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
