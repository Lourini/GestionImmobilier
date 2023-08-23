package com.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestion.domain.Bien;
import com.gestion.domain.Programme;
import com.gestion.service.BienService;
import com.gestion.service.ProgrammeService;

@Controller
public class BienController {
	
	@Autowired
	private BienService bienService;
	
	@Autowired
	private ProgrammeService programmeService;
	
	@RequestMapping("/BienList")
    public String bienList(Model model) {
		List<Bien> biens = bienService.findAll();
		model.addAttribute("bienList", biens);
        return "/bien/list";
    }
    @RequestMapping("/addBien")
	public String addBien(Model model){
    	List<Programme> programmes = programmeService.findAll();
    	model.addAttribute("programmeList", programmes);
    	model.addAttribute("bien", new Bien());
		return "bien/add";
	}
    @RequestMapping(value="/addBien" , method=RequestMethod.POST)
	public String addBienpost(@ModelAttribute("bien") Bien bien){
		bienService.create(bien);
		return "redirect:BienList";
	}

}
