package com.gestion.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.Repository.AchatLocationRepository;
import com.gestion.Repository.BienRepository;
import com.gestion.Repository.ProjetRepository;
import com.gestion.domain.Bien;
import com.gestion.service.BienService;

@Service
public class BienServiceImpl implements BienService {
	
	@Autowired
	 private  BienRepository bienRepository;
	@Autowired
	 private  ProjetRepository projetRepository;
	@Autowired
	 private  AchatLocationRepository achatLocationRepository;
	 
	@Override
	public List<Bien> findAll() {
		return bienRepository.findAll();
	}

	@Override
	public Optional<Bien> get(Long id) {
		return bienRepository.findById(id);
	}

	@Override
	public Bien create(Bien bien) {
		return bienRepository.save(bien);
	}

	@Override
	public void update(Long id, Bien bien) {
		Optional<Bien> bien1 = bienRepository.findById(id);
		bienRepository.save(bien);
	}

	@Override
	public void delete(Long id) {
		bienRepository.deleteById(id);
	}

}
