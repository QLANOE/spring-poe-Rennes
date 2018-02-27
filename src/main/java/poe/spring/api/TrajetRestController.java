package poe.spring.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger("poe.spring.api.TrajetRestController");

	@Autowired
	TrajetServices trajetServices;

	@PostMapping
	public Trajet save(@RequestBody Trajet trajet) {
		Trajet savedTrajet;
		savedTrajet = trajetServices.ajout(trajet);
		logger.debug("Trajet enregistré");
		return savedTrajet;

	}

	@GetMapping
	public List<Trajet> listerTrajet() {
		List<Trajet> savedTrajets = trajetServices.listerTrajets();
		logger.debug("Liste des trajets récupérer");
		return savedTrajets;

	}

}
