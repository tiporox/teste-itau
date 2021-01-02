package br.com.teste.itau.password.rule;

import org.apache.commons.lang3.StringUtils;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class MinSizeRule implements PasswordRule {
	
	private static final Integer MIN_SIZE = 9;

	@Override
	public boolean isValid(final String password) {
		return StringUtils.isNotBlank(password) && password.length() >= MIN_SIZE;
	}

	@Override
	public PasswordRuleError getError() {
		return PasswordRuleError.MIN_SIZE;
	}

}
