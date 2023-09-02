package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Projet;


public interface ProjetRepository extends JpaRepository<Projet, Long> {

    

}
