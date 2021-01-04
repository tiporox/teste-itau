package br.com.teste.itau.password.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorDTO;
import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class PasswordPoliciesValidatorServiceImplTest {

	@InjectMocks
	public PasswordPoliciesValidatorService service;

	@BeforeEach
    public void setUp() {
		service = new PasswordPoliciesValidatorServiceImpl();
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void returnFalseToEmptyPassword() {
		
		PasswordPoliciesValidatorResponseDTO response = service.isValid(new PasswordPoliciesValidatorDTO(""));
		
		assertFalse(response.isValid());
		assertEquals(response.getErrors().size(), 7);
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_DIGITS));
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_LOWERCASE_LETTER));
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_SIZE));
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_SPECIAL_CHARS));
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_UPPERCASE_LETTER));
		assertTrue(response.getErrors().contains(PasswordRuleError.NO_CHAR_REPETITION));
		assertTrue(response.getErrors().contains(PasswordRuleError.NON_INVALID_CHARS));
	}
	
	@Test
	public void returnFalseToNullPassword() {
		
		PasswordPoliciesValidatorResponseDTO response = service.isValid(new PasswordPoliciesValidatorDTO(null));
		
		assertFalse(response.isValid());
		assertEquals(response.getErrors().size(), 7);
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_DIGITS));
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_LOWERCASE_LETTER));
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_SIZE));
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_SPECIAL_CHARS));
		assertTrue(response.getErrors().contains(PasswordRuleError.MIN_UPPERCASE_LETTER));
		assertTrue(response.getErrors().contains(PasswordRuleError.NO_CHAR_REPETITION));
		assertTrue(response.getErrors().contains(PasswordRuleError.NON_INVALID_CHARS));
	}
	
	@Test
	public void returnTrueToValidPassword() {
		
		PasswordPoliciesValidatorResponseDTO response = service.isValid(new PasswordPoliciesValidatorDTO("AbTp9!fok"));
		
		assertTrue(response.isValid());
		assertEquals(response.getErrors().size(), 0);
	}
	
	@Test
	public void returnFalseToBusinessCasesExemples() {
		
		Arrays.asList("", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok").forEach(password -> {
			PasswordPoliciesValidatorResponseDTO response = service.isValid(new PasswordPoliciesValidatorDTO(password));
			
			assertFalse(response.isValid());
			assertTrue(response.getErrors().size() > 0);
		});

	}

}
