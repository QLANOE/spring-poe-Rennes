package poe.spring.controller;

import javax.management.BadAttributeValueExpException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.form.UserForm;
import poe.spring.services.UserServices;

@Controller
@RequestMapping("/")
public class HomePageController<User> {

	@Autowired
	UserServices userService;

	@GetMapping
	public String accueilPersonnage(Model model, @RequestParam(name = "login", required = false) String login) {
		if (login != null) {
			model.addAttribute("login", login);
		} else {
			model.addAttribute("login", " mec inconnu");
		}
		return "index";
	}

	@GetMapping("/inscription")
	public String listerUser(UserForm form, Model model) {
		return "inscription";
	}

	@PostMapping("/sauvegardeUser")
	public String sauvegarderPersonnage(@Valid UserForm form, BindingResult bindingResult, RedirectAttributes attr) {
		if (bindingResult.hasErrors()) {
			return "inscription";
		}

		try {
			userService.inscription(form.getLogin(), form.getPassword());
			attr.addAttribute("login", form.getLogin());
		} catch (BadAttributeValueExpException e) {
			System.out.println("le login n'est pas valable");
			e.printStackTrace();
			return "inscription";
		}

		return "redirect:/";
	}

}
