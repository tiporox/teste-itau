package br.com.teste.itau.password.rule;

import org.apache.commons.lang3.StringUtils;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class MinSpecialCharactersRule implements PasswordRule {
	
	private static final Integer MIN = 1;

	@Override
	public boolean isValid(final String password) {
		return StringUtils.isNotBlank(password) && password.replaceAll("[^\\!@#\\$\\%\\^&\\*()\\-\\+]", "").length() >= MIN;
	}

	@Override
	public PasswordRuleError getError() {
		return PasswordRuleError.MIN_SPECIAL_CHARACTER;
	}

}
