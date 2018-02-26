package poe.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.model.Trajet;
import poe.spring.services.TrajetServices;

@RestController
@RequestMapping("/api/trajet")

public class TrajetRestController {

	@Autowired
	TrajetServices trajetServices;

	@PostMapping
	public Trajet save(@RequestBody Trajet trajet) {
		Trajet savedTrajet;
		savedTrajet = trajetServices.ajout(trajet);
		return savedTrajet;

	}

	@GetMapping
	public List<Trajet> listerUser() {
		List<Trajet> savedTrajets = trajetServices.listerTrajets();
		return savedTrajets;

	}

}
