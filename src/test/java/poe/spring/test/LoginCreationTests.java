package poe.spring.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.metier.LoginCreation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginCreationTests {

	@Test
	public void testTailleLogin() {

		// trop petit
		String login = buildStringWithSizeBetween(LoginCreation.TAILLE_MIN - 1);
		assertThat(LoginCreation.checkTailleLogin(login)).isFalse();

		// taille limite inférieure
		login = buildStringWithSizeBetween(LoginCreation.TAILLE_MIN);
		assertThat(LoginCreation.checkTailleLogin(login)).isTrue();

		// taille limite supérieure
		login = buildStringWithSizeBetween(LoginCreation.TAILLE_MAX);
		assertThat(LoginCreation.checkTailleLogin(login)).isTrue();

		// trop grand
		login = buildStringWithSizeBetween(LoginCreation.TAILLE_MAX + 1);
		assertThat(LoginCreation.checkTailleLogin(login)).isFalse();
	}

	public String buildStringWithSizeBetween(int size) {

		String str = "";
		for (int i = 0; i < size; i++) {
			str += "0";
		}

		return str;
	}

	@Test
	public void testLoginInterdit() {

		// présent dans la liste interdite
		String loginFaux = "toto";
		String loginVraie = "bob";

		assertThat(LoginCreation.checkLoginInterdit(loginVraie)).isTrue();
		assertThat(LoginCreation.checkLoginInterdit(loginFaux)).isFalse();
	}

	@Test
	public void testEnsemble() {

		String loginFaux = "titi";
		String loginVraie = "billy";
		String loginPetit = "abc";
		String loginGrand = "abcdefghijkl";

		assertThat(LoginCreation.testsLogin(loginVraie)).isTrue();
		assertThat(LoginCreation.testsLogin(loginFaux)).isFalse();
		assertThat(LoginCreation.testsLogin(loginPetit)).isFalse();
		assertThat(LoginCreation.testsLogin(loginGrand)).isFalse();
	}

}
