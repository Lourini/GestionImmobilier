package com.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.domain.Reclamation;
import com.gestion.domain.UserReclamation;
import com.gestion.domain.User;


public interface UserReclamationRepository extends JpaRepository<UserReclamation, Long> {

    UserReclamation findFirstByUserId(User user);

    UserReclamation findFirstByReclamationId(Reclamation reclamation);

}
