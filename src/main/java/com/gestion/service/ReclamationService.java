package com.gestion.service;

import java.util.List;
import java.util.Optional;

import com.gestion.domain.Reclamation;

public interface ReclamationService {
	
	 List<Reclamation> findAll();
	 
	 Optional<Reclamation> findById(Long id);
	 
	 Reclamation create(Reclamation reclamation);
	 
	 Reclamation update(Reclamation reclamation);
	 
	 void deleteById(Long id);
	

}
