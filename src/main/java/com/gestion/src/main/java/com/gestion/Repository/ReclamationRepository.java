package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Reclamation;


public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}
