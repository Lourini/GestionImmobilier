package com.gestion.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.Repository.CanalRepository;
import com.gestion.Repository.EtatRepository;
import com.gestion.Repository.ReclamationRepository;
import com.gestion.Repository.UserReclamationRepository;
import com.gestion.domain.Reclamation;
import com.gestion.service.ReclamationService;

@Service
public class ReclamationServiceImpl implements ReclamationService{
	@Autowired
	 private ReclamationRepository reclamationRepository;
	@Autowired
	private EtatRepository etatRepository;
	@Autowired
	private CanalRepository canalRepository;
	@Autowired
	private UserReclamationRepository userReclamationRepository;
  
	@Override
	public List<Reclamation> findAll() {
		return reclamationRepository.findAll();
	}

	@Override
	public Optional<Reclamation> findById(Long id) {
		return reclamationRepository.findById(id);
	}

	@Override
	public Reclamation create(Reclamation reclamation) {
		return reclamationRepository.save(reclamation);
	}

	@Override
	public Reclamation update(Reclamation reclamation) {
		return reclamationRepository.save(reclamation);
	}

	@Override
	public void deleteById(Long id) {
		reclamationRepository.deleteById(id);
		
	}

}
