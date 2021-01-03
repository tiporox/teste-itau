package br.com.teste.itau.password.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseBaseDTO<T> {
	
	private T data;
	private Integer status;
	private String error;
	private String message;
	private final Date timestamp = new Date();
	
}
