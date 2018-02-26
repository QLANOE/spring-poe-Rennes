package poe.spring.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginCreation {

	public static final int TAILLE_MIN = 4;
	public static final int TAILLE_MAX = 10;

	static final List<String> LOGINS_INTERDIT = new ArrayList<>(
			Arrays.asList("toto", "tata", "titi", "Guillaume, Nicolas"));

	public static boolean checkTailleLogin(String login) {

		boolean isBonneTaille = false;

		if (login.length() >= TAILLE_MIN && login.length() <= TAILLE_MAX) {
			isBonneTaille = true;
		}
		return isBonneTaille;

	}

	public static boolean checkLoginInterdit(String login) {

		boolean estInterdit = true;

		for (int i = 0; (i < LOGINS_INTERDIT.size()) && estInterdit; i++) {
			if (LOGINS_INTERDIT.get(i).equalsIgnoreCase(login)) {
				estInterdit = false;
			}
		}

		return estInterdit;
	}

	public static boolean testsLogin(String login) {
		boolean checkTailleLogin = checkTailleLogin(login);
		boolean checkLoginInterdit = checkLoginInterdit(login);
		return (checkLoginInterdit && checkTailleLogin);
	}

}
