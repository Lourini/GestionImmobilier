package com.gestion.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.Repository.BienRepository;
import com.gestion.Repository.ProgrammeRepository;
import com.gestion.Repository.ProjetRepository;
import com.gestion.domain.Projet;
import com.gestion.service.ProjetService;


@Service
public class ProjetServiceImpl implements ProjetService {
	
	@Autowired
    private ProjetRepository projetRepository;
	@Autowired
    private ProgrammeRepository programmeRepository;
	@Autowired
    private BienRepository bienRepository;


	@Override
	public List<Projet> findAll() {
		return projetRepository.findAll();
	}

	@Override
	public Optional<Projet> get(Long id) {
		return projetRepository.findById(id);
	}

	@Override
	public Projet create(Projet projet) {
		return projetRepository.save(projet);
	}

	@Override
	public void update(Long id, Projet projet) {
		projetRepository.save(projet);		
	}

	@Override
	public void delete(Long id) {
		projetRepository.deleteById(id);
	}

}
