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
	
	public static class Builder {
		
		private final List<PasswordRuleError> errors;
		private final boolean isValid;
		
		public Builder(List<PasswordRuleError> errors) {
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
	
}
