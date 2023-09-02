package com.gestion.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.Repository.ProgrammeRepository;
import com.gestion.Repository.ProjetRepository;
import com.gestion.Repository.VilleRepository;
import com.gestion.domain.Programme;
import com.gestion.service.ProgrammeService;



@Service
public class ProgrammeServiceImpl implements ProgrammeService {
	
	
	@Autowired
	private ProgrammeRepository programmeRepository;
	@Autowired
    private VilleRepository villeRepository;
	@Autowired
    private ProjetRepository projetRepository;

    public ProgrammeServiceImpl(final ProgrammeRepository programmeRepository,
            final VilleRepository villeRepository, final ProjetRepository projetRepository) {
        this.programmeRepository = programmeRepository;
        this.villeRepository = villeRepository;
        this.projetRepository = projetRepository;
    }

	@Override
	public List<Programme> findAll() {
		return programmeRepository.findAll();
	}

	@Override
	public Optional<Programme> get(Long id) {
		return programmeRepository.findById(id);
	}

	@Override
	public Programme create(Programme programme) {
		return programmeRepository.save(programme);
	}

	@Override
	public void update(Long id, Programme programme) {
		programmeRepository.save(programme);
		
	}

	@Override
	public void delete(Long id) {
		programmeRepository.deleteById(id);
	}
	


}
