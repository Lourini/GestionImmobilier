package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Region;


public interface RegionRepository extends JpaRepository<Region, Long> {
}
