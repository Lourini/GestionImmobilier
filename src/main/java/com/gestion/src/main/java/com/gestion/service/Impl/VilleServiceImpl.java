package com.gestion.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.Repository.VilleRepository;
import com.gestion.domain.Ville;
import com.gestion.service.VilleService;

@Service
public class VilleServiceImpl implements VilleService {
	
	@Autowired
	private VilleRepository villeRepo;

	@Override
	public List<Ville> findAll() {
		// TODO Auto-generated method stub
		return villeRepo.findAll();
	}

}
