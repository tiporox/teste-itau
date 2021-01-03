package br.com.teste.itau.password.controller.v1;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorDTO;
import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.dto.ResponseBaseDTO;
import br.com.teste.itau.password.mapper.PasswordPoliciesValidatorResponseDTOMapper;
import br.com.teste.itau.password.service.PasswordPoliciesValidatorService;


@RestController
@RequestMapping("/v1/passwords/policies")
public class PasswordPoliciesController {

	@Autowired
	private PasswordPoliciesValidatorService passwordPoliciesValidatorService;
	
	@PostMapping(path = "validate", produces = {"application/json"})
	ResponseBaseDTO validate(@Valid @RequestBody PasswordPoliciesValidatorDTO passwordPoliciesValidatorDTO, HttpServletResponse response) {
		PasswordPoliciesValidatorResponseDTO passwordPoliciesValidatorResponseDTO = passwordPoliciesValidatorService.isValid(passwordPoliciesValidatorDTO);
		ResponseBaseDTO responseDTO = PasswordPoliciesValidatorResponseDTOMapper.from(passwordPoliciesValidatorResponseDTO);
		response.setStatus(responseDTO.getStatus());
		return responseDTO;
	}
	
	
}
