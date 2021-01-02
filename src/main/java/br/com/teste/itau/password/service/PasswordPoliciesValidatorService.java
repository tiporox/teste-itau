package br.com.teste.itau.password.service;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorDTO;
import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;

public interface PasswordPoliciesValidatorService {

	PasswordPoliciesValidatorResponseDTO isValid(final PasswordPoliciesValidatorDTO passwordPoliciesValidatorDTO);

}
