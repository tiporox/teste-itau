package br.com.teste.itau.password.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class MinUppercaseLetterRuleTest {
	
	@Test
	public void returnFalseToNullPasswords() {
		final String password = null;
		MinUppercaseLetterRule target = new MinUppercaseLetterRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_UPPERCASE_LETTER);
	}
	
	@Test
	public void returnFalseToPasswordsWithoutUppercaseLetters() {
		final String password = "abcde";
		MinUppercaseLetterRule target = new MinUppercaseLetterRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_UPPERCASE_LETTER);
	}
	
	@Test
	public void returnTrueToPasswordsWithUppercaseLetters() {
		
		for(char i = 'A'; i <= 'Z'; i++) {
			final String password = "abcde" + i;
			MinUppercaseLetterRule target = new MinUppercaseLetterRule();
			
			assertTrue(target.isValid(password));
			assertEquals(target.getError(), PasswordRuleError.MIN_UPPERCASE_LETTER);
		}

	}
	

}
