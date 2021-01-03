package br.com.teste.itau.password.mapper;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.dto.ResponseBaseDTO;

public class PasswordPoliciesValidatorResponseDTOMapper {
	
	private PasswordPoliciesValidatorResponseDTOMapper() {
		
	}
	
	public static ResponseBaseDTO from(PasswordPoliciesValidatorResponseDTO passwordPoliciesValidatorResponseDTO) {
		if(passwordPoliciesValidatorResponseDTO != null) {
			ResponseBaseDTO responseDTO = ResponseBaseDTO.builder()
				.data(passwordPoliciesValidatorResponseDTO)
				.status(passwordPoliciesValidatorResponseDTO.isValid() ? 200 : 400)
				.build();
			return responseDTO;
		}
		return ResponseBaseDTO.builder()
				.data(null)
				.status(400)
				.build();
	}

}
