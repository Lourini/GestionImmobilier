package com.gestion.service;

import java.util.List;
import java.util.Optional;

import com.gestion.domain.Bien;




public interface BienService {
	
	 List<Bien> findAll();
	 
	 Optional<Bien> get(final Long id);
	 
	 Bien create(final Bien bien);
	 
	 void update(final Long id, final Bien bien);
	 
	 void delete(final Long id);

}
