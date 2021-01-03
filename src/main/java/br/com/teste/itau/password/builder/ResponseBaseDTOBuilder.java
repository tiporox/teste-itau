package br.com.teste.itau.password.builder;

import br.com.teste.itau.password.dto.ResponseBaseDTO;

public class ResponseBaseDTOBuilder<T> {
	
	private ResponseBaseDTO<T> responseBaseDTO;
	
	public ResponseBaseDTOBuilder() {
		responseBaseDTO = new ResponseBaseDTO<T>();
	}
	
	public ResponseBaseDTOBuilder<T> data(T data) {
		responseBaseDTO.setData(data);
		return this;
	}
	
	public ResponseBaseDTOBuilder<T> message(String message) {
		responseBaseDTO.setMessage(message);
		return this;
	}
	
	public ResponseBaseDTOBuilder<T> error(String error) {
		responseBaseDTO.setError(error);
		return this;
	}
	
	public ResponseBaseDTOBuilder<T> status(Integer status) {
		responseBaseDTO.setStatus(status);
		return this;
	}
	
	public ResponseBaseDTO<T> build() {
        return this.responseBaseDTO;
    }

}