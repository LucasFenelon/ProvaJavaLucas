package br.com.servicocampanha.test;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import br.com.servicocampanha.model.Campanha;


public class CampanhaTest {
	
	@Test
	public void validaRetornoListaCampanha(){
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/campanha", String.class);
		
		System.out.println(result);
	}
	
	@Test
	public void validaRetornoDeleteCampanha(){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
	    
		params.put("id", "4");
		restTemplate.delete("http://localhost:8080/campanha/{id}", params);
		System.out.println(restTemplate.toString());
	}
	
	@Test
	public void validaRetornoCrateCampanha(){
		RestTemplate restTemplate = new RestTemplate();

		Campanha campanha = new Campanha(String.format("testeCampanha_%s", Math.random()), new Long(2), new Date(new java.util.Date().getTime()));
		restTemplate.postForEntity("http://localhost:8080/campanha", campanha, String.class);		
		System.out.println(restTemplate.toString());
	}
}
