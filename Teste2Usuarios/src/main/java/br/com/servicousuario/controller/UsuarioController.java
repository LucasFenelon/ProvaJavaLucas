package br.com.servicousuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientResponseException;

import br.com.servicousuario.model.CampanhaUsuario;
import br.com.servicousuario.model.Usuario;
import br.com.servicousuario.service.UsuarioService;

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE, value="/operacadeassociacao")
	public ResponseEntity<Iterable<CampanhaUsuario>> operacaoAssociaUsuarioCampanhas(@RequestBody String email) 
			throws RestClientResponseException{		
		try{
			Usuario usuario = usuarioService.getUsuariosByEmail(email);
			
			if(usuario != null){
				return new ResponseEntity<Iterable<CampanhaUsuario>>(
						usuarioService.associaUsuarioComDemaisCampanhasDoTime(usuario), HttpStatus.CREATED);				
			}else{
				usuarioService.salvaUsuario(usuario);
				return new ResponseEntity<Iterable<CampanhaUsuario>>(
						usuarioService.associaUsuarioComDemaisCampanhasDoTime(usuario), HttpStatus.CREATED);
			}
		}catch (Exception e) {
			throw new RestClientResponseException(e.getMessage(), 500, null, null, new byte[0], null);
		}
	}
}
