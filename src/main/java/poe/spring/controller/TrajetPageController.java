package poe.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poe.spring.form.TrajetForm;
import poe.spring.model.Trajet;
import poe.spring.model.User;
import poe.spring.services.TrajetServices;
import poe.spring.services.UserServices;

@Controller
@RequestMapping("/trajet")
public class TrajetPageController {

	@Autowired
	TrajetServices trajetService;

	@Autowired
	UserServices userServices;

	@GetMapping
	public String accueilTrajet(Model model) {
		return "indexTrajet";
	}

	@GetMapping("/creationTrajet")
	public String listerUser(TrajetForm form, Model model) {
		List<User> users = userServices.listerUsers();
		model.addAttribute("users", users);
		return "/creationTrajet";
	}

	@PostMapping("/sauvegardeTrajet")
	public String sauvegarderTrajet(@Valid TrajetForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "creationTrajet";
		}

		Trajet trajet = form.trajetFormToTrajet();
		trajetService.ajout(trajet);

		return "redirect:/trajet";
	}

	@GetMapping("/listTrajets")
	public String listTrajet(Model model, @RequestParam(value = "ville", required = false) String ville) {

		if (ville == null) {
			List<Trajet> trajets = trajetService.listerTrajets();
			model.addAttribute("trajets", trajets);
			return "/listTrajets";
		} else {
			List<Trajet> trajets = trajetService.chercherParVilleDepartOuVillaArrivee(ville, ville);
			return "/listTrajets";
		}
	}

}
