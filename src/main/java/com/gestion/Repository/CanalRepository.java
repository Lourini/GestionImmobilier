package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Canal;


public interface CanalRepository extends JpaRepository<Canal, Long> {
}
