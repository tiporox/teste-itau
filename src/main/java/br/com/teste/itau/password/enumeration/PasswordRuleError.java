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
	MIN_SPECIAL_CHARS("PASSWORD_MIN_SPECIAL_CHARS_ERROR", "Password must contain at least one special chars !@#$%^&*()-+"),
	NO_CHAR_REPETITION("PASSWORD_NO_CHAR_REPETITION_ERROR", "Password can't have chars repetition"),
	NON_INVALID_CHARS("PASSWORD_NON_INVALID_CHARS_ERROR", "Password can't have invalids chars, check spaces");
	
	private String message;

	@JsonProperty("rule_name")
	private String ruleName;
	
	private PasswordRuleError(String ruleName, String message) {
		this.ruleName = ruleName;
		this.message = message;
	}

}
