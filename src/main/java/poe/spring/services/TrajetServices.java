package poe.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.model.Trajet;
import poe.spring.repository.TrajetRepository;

@Service
public class TrajetServices {

	@Autowired
	TrajetRepository trajetRepository;

	public Trajet ajout(Trajet trajet) {

		trajetRepository.save(trajet);

		return trajet;

	}

	public List<Trajet> listerTrajets() {

		List<Trajet> trajets = (List<Trajet>) trajetRepository.findAll();
		return trajets;
	}

	public Trajet chercherTrajet(Long id) {

		Trajet trajet = trajetRepository.findOne(id);
		return trajet;
	}

	public List<Trajet> chercherParVilleDepartOuVillaArrivee(String ville, String villebis) {

		List<Trajet> listTrajet = trajetRepository.findByVilleDepartOrVilleArrivee(ville, villebis);

		return listTrajet;

	}
}
