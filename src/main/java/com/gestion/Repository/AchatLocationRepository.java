package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.AchatLocation;
import com.gestion.domain.Bien;
import com.gestion.domain.User;


public interface AchatLocationRepository extends JpaRepository<AchatLocation, Long> {

    AchatLocation findFirstByBienId(Bien bien);

    AchatLocation findFirstByUserId(User users);

}
