package br.com.teste.itau.password.rule;

import org.apache.commons.lang3.StringUtils;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class MinDigitsRule implements PasswordRule {
	
	private static final Integer MIN_DIGITS = 1;

	@Override
	public boolean isValid(final String password) {
		return StringUtils.isNotBlank(password) && password.replaceAll("[^\\d]", "").length() >= MIN_DIGITS;
	}

	@Override
	public PasswordRuleError getError() {
		return PasswordRuleError.MIN_DIGITS;
	}

}
