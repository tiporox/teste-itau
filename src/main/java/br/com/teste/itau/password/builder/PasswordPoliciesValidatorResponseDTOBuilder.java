package br.com.teste.itau.password.builder;

import java.util.List;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class PasswordPoliciesValidatorResponseDTOBuilder {
	
	private final List<PasswordRuleError> errors;
	private final boolean isValid;
	
	public PasswordPoliciesValidatorResponseDTOBuilder(List<PasswordRuleError> errors) {
		this.errors = errors;
		this.isValid = (errors == null || errors.size() == 0);		
	}
	
	public PasswordPoliciesValidatorResponseDTO build() {
		PasswordPoliciesValidatorResponseDTO passwordPoliciesValidatorResponseDTO = new PasswordPoliciesValidatorResponseDTO();
		passwordPoliciesValidatorResponseDTO.setErrors(errors);
		passwordPoliciesValidatorResponseDTO.setValid(isValid);
		return passwordPoliciesValidatorResponseDTO;
	}
}
