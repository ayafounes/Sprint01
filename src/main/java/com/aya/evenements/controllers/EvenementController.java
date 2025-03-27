package com.aya.evenements.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.aya.evenements.entities.Evenement;
import com.aya.evenements.service.EvenementService;

@Controller
public class EvenementController {

	@Autowired
	EvenementService evenementService;

	@RequestMapping("/ListeEvenements")
	public String listeEvenements(ModelMap modelMap,
	        @RequestParam(name = "page", defaultValue = "0") int page,
	        @RequestParam(name = "size", defaultValue = "2") int size) {
	    
	    Page<Evenement> events = evenementService.getAllEvenementsParPage(page, size);
	    
	    modelMap.addAttribute("evenements", events);
	    modelMap.addAttribute("pages", new int[events.getTotalPages()]);
	    modelMap.addAttribute("currentPage", page);
	    modelMap.addAttribute("size", size);
	    
	    return "listeEvenements";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createEvenement";
	}

	@RequestMapping("/saveEvenement")
	public String saveEvenement(@ModelAttribute("evenement") Evenement evenement, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// Conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEvenement = dateformat.parse(date);
		evenement.setDateEvenement(dateEvenement);

		Evenement savedEvent = evenementService.saveEvenement(evenement);
		String msg = "Événement enregistré avec Id " + savedEvent.getIdEvenement();
		modelMap.addAttribute("msg", msg);
		return "createEvenement";
	}

	@RequestMapping("/supprimerEvenement")
	public String supprimerEvenement(
	        @RequestParam("id") Long id,
	        ModelMap modelMap,
	        @RequestParam(name = "page", defaultValue = "0") int page,
	        @RequestParam(name = "size", defaultValue = "2") int size) {
	    
	    evenementService.deleteEvenementById(id);
	    Page<Evenement> events = evenementService.getAllEvenementsParPage(page, size);
	    
	    modelMap.addAttribute("evenements", events.getContent());
	    modelMap.addAttribute("pages", new int[events.getTotalPages()]);
	    modelMap.addAttribute("currentPage", page);
	    modelMap.addAttribute("size", size);
	    
	    return "listeEvenements";
	}

	@RequestMapping("/modifierEvenement")
	public String editerEvenement(@RequestParam("id") Long id, ModelMap modelMap) {
		Evenement e = evenementService.getEvenement(id);
		modelMap.addAttribute("evenement", e);
		return "editerEvenement";
	}

	@RequestMapping("/updateEvenement")
	public String updateEvenement(@ModelAttribute("evenement") Evenement evenement, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// Conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEvenement = dateformat.parse(date);
		evenement.setDateEvenement(dateEvenement);

		evenementService.updateEvenement(evenement);
		List<Evenement> events = evenementService.getAllEvenements();
		modelMap.addAttribute("evenements", events);
		return "listeEvenements";
	}
}