package br.com.teste.itau.password.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseBaseDTO {
	
	private final Object data;
	private final Integer status = 200;
	private final String error;
	private final String message;
	private final Date timestamp = new Date();
	
}
