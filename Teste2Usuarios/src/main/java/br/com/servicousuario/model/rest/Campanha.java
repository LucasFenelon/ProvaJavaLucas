package br.com.servicousuario.model.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Campanha {
	
	public List<CampanhaTo> getListaCampanhas(){
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		List<CampanhaTo> myObjects = new ArrayList<CampanhaTo>();
		
		try {
			String result = restTemplate.getForObject("http://localhost:8081/campanha", String.class);
			myObjects = mapper.readValue(result, new TypeReference<List<CampanhaTo>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return myObjects;
	}
}
