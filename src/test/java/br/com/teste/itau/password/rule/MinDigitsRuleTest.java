package br.com.teste.itau.password.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class MinDigitsRuleTest {
	
	@Test
	public void returnFalseToNullPasswords() {
		final String password = null;
		MinDigitsRule target = new MinDigitsRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_DIGITS);
	}
	
	@Test
	public void returnFalseToPasswordsWithoutDigits() {
		final String password = "abcd";
		MinDigitsRule target = new MinDigitsRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_DIGITS);
	}
	
	@Test
	public void returnTrueToPasswordWithDigits() {
		
		Arrays.asList(0,1,2,3,4,5,6,7,8,9).forEach(digit -> {
			final String password = "abcd" + digit;
			MinDigitsRule target = new MinDigitsRule();
			
			assertTrue(target.isValid(password));
			assertEquals(target.getError(), PasswordRuleError.MIN_DIGITS);
		});

	}
	

}
