package com.gestion.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestion.domain.Ville;
import com.gestion.domain.Projet;
import com.gestion.service.ProjetService;
import com.gestion.service.VilleService;

@Controller
public class ProjetController {
	
	@Autowired
	private ProjetService projetservice;
	
	@Autowired
	private VilleService villeService;
	
	@RequestMapping("/ProjetList")
    public String projetList(Model model) {
		List<Projet> projets = projetservice.findAll();
		model.addAttribute("projetList", projets);
        return "/projet/list";
    }
    @RequestMapping("/addProjet")
	public String addprojet(Model model){
    	List<Ville> villes = villeService.findAll();
    	model.addAttribute("villeList", villes);
    	model.addAttribute("projet", new Projet());
		return "/projet/add";
	}
    
    
    @RequestMapping(value="/addProjet" , method=RequestMethod.POST)
	public String addprojetpost(@ModelAttribute("projet") Projet projet){
    	projetservice.create(projet);
		return "redirect:ProjetList";
	}

}
