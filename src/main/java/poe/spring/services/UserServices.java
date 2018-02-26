package poe.spring.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.BadAttributeValueExpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.metier.LoginCreation;
import poe.spring.model.User;
import poe.spring.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	UserRepository userRepository;

	protected static Logger logger = Logger.getLogger("poe.string.api.TrajetRestController");

	public User inscription(String login, String password) throws BadAttributeValueExpException {

		User user = new User();
		user.setLogin(login);
		if (chercherUserParLogin(login) == null && LoginCreation.checkLoginInterdit(login)) {
			user.setPassword(password);
			userRepository.save(user);
			logger.log(Level.FINEST, "Enregistrement effectué");
			return user;
		}
		throw new BadAttributeValueExpException(login);
	}

	public List<User> listerUsers() {

		return (List<User>) userRepository.findAll();
	}

	public User chercherUser(Long id) {

		return userRepository.findOne(id);
	}

	public User chercherUserParLogin(String login) {

		return userRepository.findByLogin(login);
	}

	public void supprimerUser(Long id) {

		userRepository.delete(id);

	}

	public User modifierUser(String login, String password, Long id) {

		User user = chercherUser(id);
		user.setLogin(login);
		user.setPassword(password);
		userRepository.save(user);
		return user;
	}

}
