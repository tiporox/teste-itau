package br.com.teste.itau.password.controller.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.teste.itau.password.dto.PasswordPoliciesValidatorDTO;
import br.com.teste.itau.password.dto.PasswordPoliciesValidatorResponseDTO;
import br.com.teste.itau.password.dto.ResponseBaseDTO;
import br.com.teste.itau.password.enumeration.PasswordRuleError;
import br.com.teste.itau.password.service.PasswordPoliciesValidatorServiceImpl;

public class PasswordPoliciesControllerTest {

	private static final int STATUS_CODE_OK = 200;
	private static final int STATUS_CODE_BAD_REQUEST = 400;
	
    @Mock
    public  PasswordPoliciesValidatorServiceImpl service;

    @Mock
    public  HttpServletResponse httpResponse;
    
    @InjectMocks
    public PasswordPoliciesController controller;
	
    public PasswordPoliciesControllerTest() {
    	controller = new PasswordPoliciesController();
        MockitoAnnotations.initMocks(this);
    }
   
    @Test
    public void assertResponseWithNullPassword() {
		List<PasswordRuleError> errors = new ArrayList<>();
		errors.add(PasswordRuleError.MIN_DIGITS);
		
    	PasswordPoliciesValidatorDTO passwordPoliciesValidatorDTO = new PasswordPoliciesValidatorDTO();
    	PasswordPoliciesValidatorResponseDTO mockServiceReturn = mockPasswordPoliciesValidatorResponseDTO(errors);

    	Mockito.when(service.isValid(passwordPoliciesValidatorDTO)).thenReturn(mockServiceReturn);
    	
    	ResponseBaseDTO response = controller.validate(passwordPoliciesValidatorDTO, httpResponse);
    	PasswordPoliciesValidatorResponseDTO responseCasted = (PasswordPoliciesValidatorResponseDTO)response.getData();
    	
    	assertEquals(response.getStatus(), STATUS_CODE_BAD_REQUEST);
    	assertEquals(response.getData(), mockServiceReturn);
    	assertEquals(responseCasted.getErrors().size(), mockServiceReturn.getErrors().size());
    	assertEquals(responseCasted.isValid(), mockServiceReturn.isValid());
    	
    }
    
    @Test
    public void assertResponseWithValidPassword() {

    	PasswordPoliciesValidatorDTO passwordPoliciesValidatorDTO = new PasswordPoliciesValidatorDTO();
    	PasswordPoliciesValidatorResponseDTO mockServiceReturn = mockPasswordPoliciesValidatorResponseDTO();

    	Mockito.when(service.isValid(passwordPoliciesValidatorDTO)).thenReturn(mockServiceReturn);
    	
    	ResponseBaseDTO response = controller.validate(passwordPoliciesValidatorDTO, httpResponse);
    	PasswordPoliciesValidatorResponseDTO responseCasted = (PasswordPoliciesValidatorResponseDTO)response.getData();
    	
    	assertEquals(response.getStatus(), STATUS_CODE_OK);
    	assertEquals(response.getData(), mockServiceReturn);
    	assertEquals(responseCasted.getErrors(), mockServiceReturn.getErrors());
    	assertEquals(responseCasted.isValid(), mockServiceReturn.isValid());
    	
    }
    
    @Test
    public void assertResponseWithNullParam() {

    	ResponseBaseDTO response = controller.validate(null, httpResponse);
    	
    	assertEquals(response.getStatus(), STATUS_CODE_BAD_REQUEST);
    	assertNull(response.getData());
    	
    }
    
    private static PasswordPoliciesValidatorResponseDTO mockPasswordPoliciesValidatorResponseDTO() {
		return mockPasswordPoliciesValidatorResponseDTO(null); 
	}
	
	private static PasswordPoliciesValidatorResponseDTO mockPasswordPoliciesValidatorResponseDTO(List<PasswordRuleError> errors) {
		PasswordPoliciesValidatorResponseDTO mock = new PasswordPoliciesValidatorResponseDTO.Builder(errors)
    			.build();
		return mock;
	}
    

    
}
