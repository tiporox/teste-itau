package br.com.teste.itau.password.rule;

import org.apache.commons.lang3.StringUtils;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class NonInvalidCharsRule implements PasswordRule {

	@Override
	public boolean isValid(final String password) {
		return StringUtils.isNotBlank(password) && password.replaceAll("[^\\s]", "").length() == 0;
	}

	@Override
	public PasswordRuleError getError() {
		return PasswordRuleError.NON_INVALID_CHARS;
	}

}
