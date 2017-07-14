package br.com.servicousuario;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class UsuarioTest {
	
	@Test
	public void validaOperacaoDeAssociacao(){
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8082/operacadeassociacao", String.class);
		
		System.out.println(result);
	}

}
