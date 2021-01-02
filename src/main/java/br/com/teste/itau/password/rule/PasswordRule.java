package br.com.teste.itau.password.rule;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public interface PasswordRule {
	boolean isValid(final String password);
	PasswordRuleError getError();
}
