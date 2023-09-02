package com.gestion.service;

import java.util.List;
import java.util.Optional;

import com.gestion.domain.Programme;



public interface ProgrammeService {
	
	List<Programme> findAll();
	
	Optional<Programme> get(final Long id);
	
	Programme create(final Programme programme);
	
	void update(final Long id, final Programme programme);
	
	void delete(final Long id);

}
