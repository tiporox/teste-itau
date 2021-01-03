package br.com.teste.itau.password.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.dto.ResponseBaseDTO;
import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class PasswordPoliciesValidatorResponseDTOMapperTest {
	
	private static final int STATUS_CODE_OK = 200;
	private static final int STATUS_CODE_BAD_REQUEST = 400;
	
	@Test
	public void returnAValidResponseBaseDTO() {
		PasswordPoliciesValidatorResponseDTO mock = mockPasswordPoliciesValidatorResponseDTO();
		ResponseBaseDTO responseBaseDTO = PasswordPoliciesValidatorResponseDTOMapper.from(mock);
		
		assertEquals(responseBaseDTO.getStatus(), STATUS_CODE_OK);
		assertEquals(responseBaseDTO.getData(), mock);
	}
	
	@Test
	public void returnAnInvalidResponseBaseDTO() {
		List<PasswordRuleError> errors = new ArrayList<>();
		errors.add(PasswordRuleError.MIN_DIGITS);
		PasswordPoliciesValidatorResponseDTO mock = mockPasswordPoliciesValidatorResponseDTO(errors);
		ResponseBaseDTO responseBaseDTO = PasswordPoliciesValidatorResponseDTOMapper.from(mock);
		
		assertEquals(responseBaseDTO.getStatus(), STATUS_CODE_BAD_REQUEST);
		assertEquals(responseBaseDTO.getData(), mock);
	}
	
	@Test
	public void returnAnInvalidesponseBaseDTOToNullPasswordPoliciesValidatorResponseDTO() {
		ResponseBaseDTO responseBaseDTO = PasswordPoliciesValidatorResponseDTOMapper.from(null);
		assertEquals(responseBaseDTO.getStatus(), STATUS_CODE_BAD_REQUEST);
		assertNull(responseBaseDTO.getData());
	}
	
	private static PasswordPoliciesValidatorResponseDTO mockPasswordPoliciesValidatorResponseDTO() {
		return mockPasswordPoliciesValidatorResponseDTO(null); 
	}
	
	private static PasswordPoliciesValidatorResponseDTO mockPasswordPoliciesValidatorResponseDTO(List<PasswordRuleError> errors) {
		PasswordPoliciesValidatorResponseDTO mock = new PasswordPoliciesValidatorResponseDTO.Builder(errors)
    			.build();
		return mock;
	}
}
