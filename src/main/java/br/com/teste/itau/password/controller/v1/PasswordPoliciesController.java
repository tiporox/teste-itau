package br.com.teste.itau.password.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorDTO;
import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.dto.ResponseBaseDTO;
import br.com.teste.itau.password.service.PasswordPoliciesValidatorService;


@RestController
@RequestMapping("/v1/passwords/policies")
public class PasswordPoliciesController {

	@Autowired
	private PasswordPoliciesValidatorService passwordPoliciesValidatorService;
	
	@PostMapping("validate")
	ResponseBaseDTO validate(@Valid @RequestBody PasswordPoliciesValidatorDTO passwordPoliciesValidatorDTO) {
		PasswordPoliciesValidatorResponseDTO passwordPoliciesValidatorResponseDTO = passwordPoliciesValidatorService.isValid(passwordPoliciesValidatorDTO);
		return ResponseBaseDTO.builder()
				.data(passwordPoliciesValidatorResponseDTO)
				.build();
	}
	
	
}
