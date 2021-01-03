package br.com.teste.itau.password.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PasswordPoliciesValidatorDTO {
	
	@NotNull(message = "Name cannot be null")
	private String password;

}
