package br.com.teste.itau.password.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordPoliciesValidatorDTO {
	
	@NotNull(message = "Name cannot be null")
	private String password;

}
