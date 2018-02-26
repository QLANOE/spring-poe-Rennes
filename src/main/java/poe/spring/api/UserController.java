package poe.spring.api;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.BadAttributeValueExpException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.model.User;
import poe.spring.services.UserServices;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserServices userServices;

	protected static Logger logger = Logger.getLogger("poe.string.api.UserController");

	@PostMapping
	public User save(@RequestBody User user) {
		User savedUser;
		try {
			savedUser = userServices.inscription(user.getLogin(), user.getPassword());
			logger.log(Level.FINE, savedUser + "");
			return savedUser;
		} catch (BadAttributeValueExpException e) {
			e.printStackTrace();
			return null;

		}

	}

	@GetMapping
	public List<User> listerUser() {
		List<User> savedUsers = userServices.listerUsers();
		logger.log(Level.FINE, savedUsers + "");
		return savedUsers;

	}

	@RequestMapping("/id/{id}")
	public User afficherUser(@PathVariable(value = "id") Long id, HttpServletResponse response) {

		User savedUser = userServices.chercherUser(id);
		if (savedUser == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			logger.log(Level.FINE, savedUser + "");
		}
		return savedUser;
	}

	@RequestMapping("/login/{login}")
	public User afficherUserParLogin(@PathVariable(value = "login") String login) {

		User savedUser = userServices.chercherUserParLogin(login);
		logger.log(Level.FINE, savedUser + "");
		return savedUser;
	}

	@RequestMapping("/supprId/{supprId}")
	public void supprimerUser(@PathVariable(value = "supprId") Long supprId) {

		userServices.supprimerUser(supprId);
	}

	@GetMapping("/{Id}")
	public User modifierUser(@RequestBody User user, @PathVariable(value = "Id") Long id) {

		User savedUser = userServices.modifierUser(user.getLogin(), user.getPassword(), id);
		logger.log(Level.FINE, savedUser + "");
		return savedUser;
	}

}
