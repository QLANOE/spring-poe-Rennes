package poe.spring.services;

import java.util.List;

import javax.management.BadAttributeValueExpException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.metier.LoginCreation;
import poe.spring.model.User;
import poe.spring.repository.UserRepository;

@Service
public class UserServices {

	Logger logger = LoggerFactory.getLogger("poe.spring.services.UserServices");

	@Autowired
	UserRepository userRepository;

	public User inscription(String login, String password) throws BadAttributeValueExpException {

		User user = new User();
		user.setLogin(login);
		if (chercherUserParLogin(login) == null && LoginCreation.checkLoginInterdit(login)) {
			user.setPassword(password);
			userRepository.save(user);
			logger.debug("User créée " + user.getId() + "	" + user.getLogin());
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
		logger.debug("User modifié " + user.getId() + "	" + user.getLogin());
		return user;
	}

}
