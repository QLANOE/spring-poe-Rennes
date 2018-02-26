package poe.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.spring.model.Trajet;

@Repository
public interface TrajetRepository extends CrudRepository<Trajet, Long> {

	List<Trajet> findByVilleDepartOrVilleArrivee(String ville, String villebis);

}
