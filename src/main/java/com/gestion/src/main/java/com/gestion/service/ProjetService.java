package com.gestion.service;

import java.util.List;
import java.util.Optional;

import com.gestion.domain.Projet;


public interface ProjetService {
	
	List<Projet> findAll();
	
	Optional<Projet> get(final Long id);
	
	Projet create(final Projet projet);
	
	void update(final Long id, final Projet projet);
	
	void delete(final Long id);

}
