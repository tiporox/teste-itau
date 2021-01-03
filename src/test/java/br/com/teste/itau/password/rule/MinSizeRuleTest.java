package br.com.teste.itau.password.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class MinSizeRuleTest {
	
	@Test
	public void returnFalseToNullPasswords() {
		final String password = null;
		MinSizeRule target = new MinSizeRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_SIZE);
	}
	
	@Test
	public void returnFalseToPasswordsLengthLessThanNineLetters() {
		final String password = "abcd";
		MinSizeRule target = new MinSizeRule();
		
		assertFalse(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_SIZE);
	}
	
	@Test
	public void returnTrueToPasswordsLengthEqualsNineLetters() {
		
		final String password = "123456789";
		MinSizeRule target = new MinSizeRule();
		
		assertTrue(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_SIZE);

	}
	
	@Test
	public void returnTrueToPasswordsLengthOverThanNineLetters() {
		
		final String password = "1234567891";
		MinSizeRule target = new MinSizeRule();
		
		assertTrue(target.isValid(password));
		assertEquals(target.getError(), PasswordRuleError.MIN_SIZE);

	}
	

}
