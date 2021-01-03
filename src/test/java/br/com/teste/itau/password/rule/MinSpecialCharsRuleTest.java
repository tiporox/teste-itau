package br.com.teste.itau.password.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class MinSpecialCharsRuleTest {
	
	@Test
	public void returnFalseToNullPasswords() {
		final String password = null;
		MinSpecialCharsRule target = new MinSpecialCharsRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_SPECIAL_CHARS);
	}
	
	@Test
	public void returnFalseToPasswordsWithoutSpecialChars() {
		final String password = "abcde";
		MinSpecialCharsRule target = new MinSpecialCharsRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_SPECIAL_CHARS);
	}
	
	@Test
	public void returnTrueToPasswordsWithSpecialChars() {		
		Arrays.asList('!','@','#','$','%','^','&','*','(',')','-','+').forEach(specialChar -> {
			final String password = "abcde" + specialChar;
			MinSpecialCharsRule target = new MinSpecialCharsRule();
			
			assertTrue(target.isValid(password));
			assertEquals(target.getError(), PasswordRuleError.MIN_SPECIAL_CHARS);
		});

	}
	

}
