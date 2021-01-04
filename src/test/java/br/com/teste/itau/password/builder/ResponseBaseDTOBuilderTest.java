package br.com.teste.itau.password.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.teste.itau.password.dto.ResponseBaseDTO;

public class ResponseBaseDTOBuilderTest {

	public static final Object DATA = new Object();
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	public static final Integer STATUS = 200;
	
	
	@Test
	public void checkDataConsistence() {
		
		ResponseBaseDTO<Object> response = new ResponseBaseDTOBuilder<Object>()
				.data(DATA)
				.error(ERROR)
				.message(MESSAGE)
				.status(STATUS)
				.build();
		
		assertEquals(response.getData(), DATA);
		assertEquals(response.getError(), ERROR);
		assertEquals(response.getMessage(), MESSAGE);
		assertEquals(response.getStatus(), STATUS);
		assertNotNull(response.getTimestamp());
		
	}

	
}
