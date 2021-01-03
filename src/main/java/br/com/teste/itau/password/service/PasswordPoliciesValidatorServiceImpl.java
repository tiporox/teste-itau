package br.com.teste.itau.password.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.teste.itau.password.builder.PasswordPoliciesValidatorResponseDTOBuilder;
import br.com.teste.itau.password.dto.PasswordPoliciesValidatorDTO;
import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.enumeration.PasswordRuleError;
import br.com.teste.itau.password.rule.MinDigitsRule;
import br.com.teste.itau.password.rule.MinLowrcaseLetterRule;
import br.com.teste.itau.password.rule.MinSizeRule;
import br.com.teste.itau.password.rule.MinSpecialCharsRule;
import br.com.teste.itau.password.rule.MinUppercaseLetterRule;
import br.com.teste.itau.password.rule.NoCharsRepetitionsRule;
import br.com.teste.itau.password.rule.NonInvalidCharsRule;
import br.com.teste.itau.password.rule.PasswordRule;

@Service
public class PasswordPoliciesValidatorServiceImpl implements PasswordPoliciesValidatorService {
	
	private List<PasswordRule> rules;
	
	public PasswordPoliciesValidatorServiceImpl() {
		super();
		rules = Arrays.asList(			
			new MinSizeRule(), 
			new MinDigitsRule(),
			new MinLowrcaseLetterRule(),
			new MinUppercaseLetterRule(),
			new MinSpecialCharsRule(),
			new NoCharsRepetitionsRule(),
			new NonInvalidCharsRule()
		);
	}

    public PasswordPoliciesValidatorResponseDTO isValid(final PasswordPoliciesValidatorDTO passwordPoliciesValidatorDTO) {
    	final List<PasswordRuleError> errors = new ArrayList<>();
    	rules.forEach(rule -> {
    		if(!rule.isValid(passwordPoliciesValidatorDTO.getPassword())) {
    			errors.add(rule.getError());
    		}
    	});

    	return new PasswordPoliciesValidatorResponseDTOBuilder(errors)
    			.build();
    }

}
