package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Programme;


public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
	
}
