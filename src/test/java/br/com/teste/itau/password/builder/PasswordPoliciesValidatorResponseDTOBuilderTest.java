package br.com.teste.itau.password.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class PasswordPoliciesValidatorResponseDTOBuilderTest {
	
	@Test
	public void returnPasswordPoliciesValidatorResponseDTOWithInvalidPassword() {
		
		List<PasswordRuleError> errors = new ArrayList<>();
		errors.add(PasswordRuleError.MIN_DIGITS);
		PasswordPoliciesValidatorResponseDTO response = new PasswordPoliciesValidatorResponseDTOBuilder(errors).build();
		
		assertFalse(response.isValid());
		assertEquals(response.getErrors(), errors);
		assertEquals(response.getErrors().size(), 1);
		
	}
	
	@Test
	public void returnPasswordPoliciesValidatorResponseDTOWithValidPassword() {
		
		List<PasswordRuleError> errors = new ArrayList<>();
		PasswordPoliciesValidatorResponseDTO response = new PasswordPoliciesValidatorResponseDTOBuilder(errors).build();
		
		assertTrue(response.isValid());
		assertEquals(response.getErrors(), errors);
		assertEquals(response.getErrors().size(), 0);
		
	}
	
	@Test
	public void returnPasswordPoliciesValidatorResponseDTOWithNullErrors() {
		
		PasswordPoliciesValidatorResponseDTO response = new PasswordPoliciesValidatorResponseDTOBuilder(null).build();
		
		assertTrue(response.isValid());
		assertNull(response.getErrors());
		
	}

}
