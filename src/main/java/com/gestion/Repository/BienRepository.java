package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Bien;


public interface BienRepository extends JpaRepository<Bien, Long> {


}
