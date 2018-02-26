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

		return (List<Trajet>) trajetRepository.findAll();

	}

	public Trajet chercherTrajet(Long id) {

		return trajetRepository.findOne(id);
	}

	public List<Trajet> chercherParVilleDepartOuVillaArrivee(String ville, String villebis) {

		return trajetRepository.findByVilleDepartOrVilleArrivee(ville, villebis);

	}
}
