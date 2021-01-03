package br.com.teste.itau.password.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class NonInvalidCharsRuleTest {
	
	@Test
	public void returnFalseToNullPasswords() {
		final String password = null;
		NonInvalidCharsRule target = new NonInvalidCharsRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.NON_INVALID_CHARS);
	}
	
	@Test
	public void returnTrueToPasswordsWithoutInvalidsChars() {
		final String password = "AbCdE123897";
		NonInvalidCharsRule target = new NonInvalidCharsRule();
		
		assertTrue(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.NON_INVALID_CHARS);
	}
	
	@Test
	public void returnFalseToPasswordsWithInvalidsChars() {
		
		Arrays.asList(" aa", "BB ", "C c").forEach(password -> {
			NonInvalidCharsRule target = new NonInvalidCharsRule();
			assertFalse(target.isValid(password));
			assertEquals(target.getError(), PasswordRuleError.NON_INVALID_CHARS);
		});

	}
	

}
