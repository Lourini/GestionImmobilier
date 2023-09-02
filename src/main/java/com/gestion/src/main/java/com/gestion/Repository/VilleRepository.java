package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Ville;


public interface VilleRepository extends JpaRepository<Ville, Long> {
}
