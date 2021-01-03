package br.com.teste.itau.password.dto;

import java.util.List;

import br.com.teste.itau.password.enumeration.PasswordRuleError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordPoliciesValidatorResponseDTO {
	
	private List<PasswordRuleError> errors;
	private boolean isValid;
	
}
