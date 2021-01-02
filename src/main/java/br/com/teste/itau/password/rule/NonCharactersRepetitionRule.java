package br.com.teste.itau.password.rule;

import org.apache.commons.lang3.StringUtils;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class NonCharactersRepetitionRule implements PasswordRule {

	@Override
	public boolean isValid(final String password) {

		if(StringUtils.isNotBlank(password)) {
			for(int i = 1; i < password.length(); i++) {
				char currentLetter = password.toLowerCase().charAt(i);
				char beforeLetter = password.toLowerCase().charAt(i - 1);
				if(currentLetter == beforeLetter) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public PasswordRuleError getError() {
		return PasswordRuleError.NON_CHARACTER_REPETITION;
	}

}
