package br.com.teste.itau.password.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class NoCharsRepetitionsRuleTest {
	
	@Test
	public void returnFalseToNullPasswords() {
		final String password = null;
		NoCharsRepetitionsRule target = new NoCharsRepetitionsRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.NO_CHAR_REPETITION);
	}
	
	@Test
	public void returnTrueToPasswordsWithoutCharRepatitions() {
		final String password = "AbCdE123897";
		NoCharsRepetitionsRule target = new NoCharsRepetitionsRule();
		
		assertTrue(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.NO_CHAR_REPETITION);
	}
	
	@Test
	public void returnFalseToPasswordsWithCharRepatitions() {
		
		Arrays.asList("aa", "BB", "Cc", "11", "a123456789a").forEach(password -> {
			NoCharsRepetitionsRule target = new NoCharsRepetitionsRule();
			assertFalse(target.isValid(password));
			assertEquals(target.getError(), PasswordRuleError.NO_CHAR_REPETITION);
		});

	}
	

}
