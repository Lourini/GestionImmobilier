package com.gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Etat;


public interface EtatRepository extends JpaRepository<Etat, Long> {
}
