package br.com.teste.itau.password.mapper;

import br.com.teste.itau.password.builder.ResponseBaseDTOBuilder;
import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.dto.ResponseBaseDTO;

public class PasswordPoliciesValidatorResponseDTOMapper {
	
	private PasswordPoliciesValidatorResponseDTOMapper() {
		
	}
	
	public static ResponseBaseDTO<PasswordPoliciesValidatorResponseDTO> from(PasswordPoliciesValidatorResponseDTO passwordPoliciesValidatorResponseDTO) {
		if(passwordPoliciesValidatorResponseDTO != null) {
			ResponseBaseDTO<PasswordPoliciesValidatorResponseDTO> responseDTO = new ResponseBaseDTOBuilder<PasswordPoliciesValidatorResponseDTO>()
				.data(passwordPoliciesValidatorResponseDTO)
				.status(passwordPoliciesValidatorResponseDTO.isValid() ? 200 : 400)
				.build();
			return responseDTO;
		}
		return new ResponseBaseDTOBuilder<PasswordPoliciesValidatorResponseDTO>()
				.data(null)
				.status(400)
				.build();
	}

}
