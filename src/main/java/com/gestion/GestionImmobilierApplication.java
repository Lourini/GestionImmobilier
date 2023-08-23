package com.gestion;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestion.Repository.VilleRepository;
import com.gestion.domain.User;
import com.gestion.domain.Ville;
import com.gestion.domain.security.Role;
import com.gestion.domain.security.UserRole;
import com.gestion.service.UserService;
import com.gestion.utility.SecurityUtility;

@SpringBootApplication
public class GestionImmobilierApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VilleRepository villeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionImmobilierApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Ville> v = villeRepository.findAll();
		User user1 = new User();
		user1.setUsername("admin");
		user1.setFirstName("Admin");
		user1.setLastName("Admin");
		user1.setPhone("+212*********");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmail("admin@gmail.com");
		user1.setVillId(v.get(0));
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}

}
