package br.com.teste.itau.password.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class MinLowrcaseLetterRuleTest {
	
	@Test
	public void returnFalseToNullPasswords() {
		final String password = null;
		MinLowrcaseLetterRule target = new MinLowrcaseLetterRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_LOWERCASE_LETTER);
	}
	
	@Test
	public void returnFalseToPasswordsWithoutLowercaseLetters() {
		final String password = "ABCDE";
		MinLowrcaseLetterRule target = new MinLowrcaseLetterRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_LOWERCASE_LETTER);
	}
	
	@Test
	public void returnTrueToPasswordsWithLowercaseLetters() {
		
		for(char i = 'a'; i <= 'z'; i++) {
			final String password = "ABCD" + i;
			MinLowrcaseLetterRule target = new MinLowrcaseLetterRule();
			
			assertTrue(target.isValid(password));
			assertEquals(target.getError(), PasswordRuleError.MIN_LOWERCASE_LETTER);
		}

	}
	

}
