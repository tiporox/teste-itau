package br.com.teste.itau.password.rule;

import org.apache.commons.lang3.StringUtils;

import br.com.teste.itau.password.enumeration.PasswordRuleError;

public class NoCharsRepetitionsRule implements PasswordRule {

	@Override
	public boolean isValid(final String password) {

		if(StringUtils.isNotBlank(password)) {
			for(int i = 0; i < password.length(); i++) {
				char currentLetter = password.toLowerCase().charAt(i);
				int count = StringUtils.countMatches(password.toLowerCase(), currentLetter);
				if(count > 1) {
					return false;
				}
			}
		} else {
			return false;
		}		
		return true;
	}

	@Override
	public PasswordRuleError getError() {
		return PasswordRuleError.NO_CHAR_REPETITION;
	}

}
