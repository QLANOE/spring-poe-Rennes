package poe.spring.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import poe.spring.model.Trajet;
import poe.spring.model.User;

public class TrajetForm {

	private String villeDepart;
	private String villeArrivee;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateDepart;
	private Double prix;
	private int nbPlace;
	private User user;

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trajet trajetFormToTrajet() {

		Trajet trajet = new Trajet();
		trajet.setVilleDepart(this.villeDepart);
		trajet.setVilleArrivee(this.villeArrivee);
		trajet.setDateDepart(this.dateDepart);
		trajet.setPrix(this.prix);
		trajet.setNbPlaces(this.nbPlace);
		trajet.setUser(user);

		return trajet;
	}

}
