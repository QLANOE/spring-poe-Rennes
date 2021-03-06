package poe.spring.test.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.model.Trajet;
import poe.spring.model.User;
import poe.spring.repository.TrajetRepository;
import poe.spring.services.TrajetServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrajetServicesTest {

	@Autowired
	TrajetRepository trajetRepository;

	@Autowired
	TrajetServices trajetServices;

	@Test
	public void creationTrajet() {

		String villeDepart = "Rennes";
		String villeArrivee = "Pace";
		Date dateDepart = null;
		double prix = 10;
		int nbPlaces = 15;
		User user = null;

		Trajet trajet = new Trajet(villeDepart, villeArrivee, dateDepart, prix, nbPlaces, user);

		Trajet trajetCreated = trajetServices.ajout(trajet);
		assertThat(trajetCreated).isNotNull();
		assertThat(trajetCreated.getVilleDepart().equals(villeDepart)).isTrue();

		Trajet userSaved = trajetRepository.findOne(trajetCreated.getId());
		assertThat(userSaved).isNotNull();
		assertThat(userSaved.getVilleDepart().equals(villeDepart)).isTrue();

	}

	@Test
	public void destructionUser() {

		String villeDepart = "Truc";
		String villeArrivee = "muche";
		Date dateDepart = null;
		double prix = 10;
		int nbPlaces = 15;
		User user = null;

		Trajet trajet = new Trajet(villeDepart, villeArrivee, dateDepart, prix, nbPlaces, user);

		Trajet trajetCreated = trajetServices.ajout(trajet);
		assertThat(trajetCreated).isNotNull();
		assertThat(trajetCreated.getVilleDepart().equals(villeDepart)).isTrue();

		trajetRepository.delete(trajetCreated.getId());

		Trajet userSaved = trajetRepository.findOne(trajetCreated.getId());
		assertThat(userSaved).isNull();

	}

}
