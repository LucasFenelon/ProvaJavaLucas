package br.com.servicocampanha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientResponseException;

import br.com.servicocampanha.model.Campanha;
import br.com.servicocampanha.service.CampanhaService;

@Controller
public class CampanhaController {
	
	@Autowired
	private CampanhaService campanhaService;	
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE,  value="/campanha")
	public ResponseEntity<Iterable<Campanha>> getCampanha() throws RestClientResponseException{
		try{
			return new ResponseEntity<Iterable<Campanha>>(campanhaService.listaCampanha(), HttpStatus.OK);
		}catch (Exception e) {
			throw new RestClientResponseException(e.getMessage(), 500, null, null, new byte[0], null);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE, value="/campanha")
	public ResponseEntity<Iterable<Campanha>> saveCampanha(@RequestBody Campanha campanha) throws RestClientResponseException{		
		try{
			return new ResponseEntity<Iterable<Campanha>>(campanhaService.salvaCampanha(campanha), HttpStatus.CREATED);
		}catch (Exception e) {
			throw new RestClientResponseException(e.getMessage(), 500, null, null, new byte[0], null);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE, value="/campanha/{id}")
	public ResponseEntity<Iterable<Campanha>> deleteCampanha(@PathVariable("id") Long id) throws RestClientResponseException{
		try{
			return new ResponseEntity<Iterable<Campanha>>(campanhaService.removeCampanha(id), HttpStatus.OK);
		}catch (Exception e) {
			throw new RestClientResponseException(e.getMessage(), 500, null, null, new byte[0], null);
		}
	}
	
//	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE,  value="/campanhaTime")
//	public ResponseEntity<List<Campanha>> getCampanhasTime(@RequestBody Campanha campanha) throws RestClientResponseException{
//		try{
//			return new ResponseEntity<List<Campanha>>(campanhaService.listaCampanha(campanha), HttpStatus.OK);
//		}catch (Exception e) {
//			throw new RestClientResponseException(e.getMessage(), 500, null, null, new byte[0], null);
//		}
//	}
}