package com.gestion.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestion.domain.Programme;
import com.gestion.domain.Projet;
import com.gestion.service.ProgrammeService;
import com.gestion.service.ProjetService;

@Controller
public class ProgrammeController {
	
	@Autowired
	private ProgrammeService programmeService;
	
	@Autowired
	private ProjetService projetservice;
	
	@RequestMapping("/ProgrammeList")
    public String programmeList(Model model) {
		List<Programme> programmes = programmeService.findAll();
		model.addAttribute("programmeList", programmes);
        return "/programme/list";
    }
	
	@RequestMapping("/addProgramme")
	public String addProgramme(Model model) {
	    List<Projet> projets = projetservice.findAll();
	    Programme programme = new Programme();
	    programme.setProjetId(new Projet()); // Set an initial value for projetId
	    model.addAttribute("projetList", projets);
	    model.addAttribute("programme", programme);
	    return "/programme/add";
	}
	
	@RequestMapping(value="/addProgramme" , method=RequestMethod.POST)
	public String addprogrammepost(@ModelAttribute("programme") Programme programme,Authentication authentication){
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
		    String authorityName = authority.getAuthority();
		    if (authorityName.equals("ROLE_ADMIN")) {
		    	//programmeService.create(programme);
		    } else if (authorityName.equals("ROLE_USER")) {
		    	programmeService.create(programme);
		    }
		});
		return "redirect:ProgrammeList";
		
	}

}
