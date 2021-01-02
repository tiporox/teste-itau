package br.com.teste.itau.password.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PasswordRuleError {
	
	MIN_SIZE("PASSWORD_MIN_SIZE_ERROR", "Password min size is 9"),
	MIN_DIGITS("PASSWORD_MIN_DIGITS_ERROR", "Password must contain at least one digit"),
	MIN_LOWERCASE_LETTER("PASSWORD_MIN_LOWERCASE_LETTER_ERROR", "Password must contain at least one lowercase letter"),
	MIN_UPPERCASE_LETTER("PASSWORD_MIN_UPPERCASE_LETTER_ERROR", "Password must contain at least one uppercase letter"),
	MIN_SPECIAL_CHARACTER("PASSWORD_MIN_SPECIAL_CHARACTER_ERROR", "Password must contain at least one special character !@#$%^&*()-+"),
	NON_CHARACTER_REPETITION("PASSWORD_NON_CHARACTER_REPETITION_ERROR", "Password can't have characters repetition"),
	NON_INVALID_CHARACTERS("PASSWORD_NON_INVALID_CHARACTERS_ERROR", "Password can't have invalids characters, check spaces");
	
	private String message;

	@JsonProperty("rule_name")
	private String ruleName;
	
	private PasswordRuleError(String ruleName, String message) {
		this.ruleName = ruleName;
		this.message = message;
	}

}
