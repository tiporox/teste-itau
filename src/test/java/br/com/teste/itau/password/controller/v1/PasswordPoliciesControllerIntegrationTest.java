package br.com.teste.itau.password.controller.v1;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.teste.itau.password.service.PasswordPoliciesValidatorServiceImpl;



@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = {PasswordPoliciesValidatorServiceImpl.class, PasswordPoliciesController.class})
public class PasswordPoliciesControllerIntegrationTest {


	@Autowired
	private MockMvc mockMvc;


	@Test
	public void postNull() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError())
        .andReturn();
	    
	}
	
	@Test
	public void postInvalidPasswordCase1() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.content("{\"password\": \"\"}")
    		.contentType(MediaType.APPLICATION_JSON)
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.data.errors").exists())
        .andExpect(jsonPath("$.data.valid").value(false))
        .andReturn();
	    
	}
	
	@Test
	public void postInvalidPasswordCase2() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.content("{\"password\": \"aa\"}")
    		.contentType(MediaType.APPLICATION_JSON)
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.data.errors").exists())
        .andExpect(jsonPath("$.data.valid").value(false))
        .andReturn();
	    
	}
	
	@Test
	public void postInvalidPasswordCase3() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.content("{\"password\": \"ab\"}")
    		.contentType(MediaType.APPLICATION_JSON)
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.data.errors").exists())
        .andExpect(jsonPath("$.data.valid").value(false))
        .andReturn();
	    
	}
	
	@Test
	public void postInvalidPasswordCase4() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.content("{\"password\": \"AAAbbbCc\"}")
    		.contentType(MediaType.APPLICATION_JSON)
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.data.errors").exists())
        .andExpect(jsonPath("$.data.valid").value(false))
        .andReturn();
	    
	}
	
	@Test
	public void postInvalidPasswordCase5() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.content("{\"password\": \"AbTp9!foo\"}")
    		.contentType(MediaType.APPLICATION_JSON)
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.data.errors").exists())
        .andExpect(jsonPath("$.data.valid").value(false))
        .andReturn();
	    
	}
	
	@Test
	public void postInvalidPasswordCase6() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.content("{\"password\": \"AbTp9!foA\"}")
    		.contentType(MediaType.APPLICATION_JSON)
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.data.errors").exists())
        .andExpect(jsonPath("$.data.valid").value(false))
        .andReturn();
	    
	}
	
	@Test
	public void postInvalidPasswordCase7() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.content("{\"password\": \"AbTp9 fok\"}")
    		.contentType(MediaType.APPLICATION_JSON)
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.data.errors").exists())
        .andExpect(jsonPath("$.data.valid").value(false))
        .andReturn();
	    
	}
	
	@Test
	public void postValidPasswordCase8() throws Exception {
		this.mockMvc.perform(
    		MockMvcRequestBuilders.post("/v1/passwords/policies/validate")
    		.content("{\"password\": \"AbTp9!fok\"}")
    		.contentType(MediaType.APPLICATION_JSON)
    		.accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(jsonPath("$.data.errors").exists())
        .andExpect(jsonPath("$.data.valid").value(true))
        .andReturn();
	    
	}
	
}
