package br.com.servicousuario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.servicousuario.model.CampanhaUsuario;
import br.com.servicousuario.model.Usuario;
import br.com.servicousuario.model.rest.Campanha;
import br.com.servicousuario.model.rest.CampanhaTo;
import br.com.servicousuario.repository.CampanhaUsuarioRepository;
import br.com.servicousuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public CampanhaUsuarioRepository campanhaUsuarioRepository;	
	
	public Usuario getUsuariosByEmail(String email){
		return usuarioRepository.findUsuarioByEmail(email);
	}
	
	public Iterable<Usuario> salvaUsuario(Usuario usuario){
		usuarioRepository.save(usuario);
		return usuarioRepository.findAll();
	}
	
	public List<CampanhaTo> getCampanhasByTime(Usuario usuario){
		Campanha campanha = new Campanha();
		
		Stream<CampanhaTo> campanhas = campanha.getListaCampanhas().stream()
				.filter(c -> c.getIdTimeCoracao() == usuario.getIdTimeCoracao());
		
		return campanhas.collect(Collectors.toList());
	}
	
	public Iterable<CampanhaUsuario> salvarCampanhaUsuario(Usuario usuario, Long idCampanha){
		campanhaUsuarioRepository.save(new CampanhaUsuario(idCampanha, usuario.getId()));
		return campanhaUsuarioRepository.findAll();
	}
	
	public Iterable<CampanhaUsuario> salvarCampanhasUsuarios(List<CampanhaUsuario> campUsr){
		campanhaUsuarioRepository.save(campUsr);
		return campanhaUsuarioRepository.findAll();
	}
	
	public List<CampanhaUsuario> getCampanhaByUsuario(Usuario usuario){
		return campanhaUsuarioRepository.findCampanhaByUsuario(usuario.getId());
	}
	
	public Iterable<CampanhaUsuario> associaUsuarioComDemaisCampanhasDoTime(Usuario usuario){
		List<CampanhaTo> campanhasTime = getCampanhasByTime(usuario);
		List<CampanhaUsuario> campanhasUsuario = getCampanhaByUsuario(usuario);
		List<CampanhaUsuario> newCampanhasUsuario = new ArrayList<CampanhaUsuario>();
		
		for(CampanhaUsuario campanha : campanhasUsuario){ 
			Optional<CampanhaTo> encontrado = campanhasTime.stream()
					.filter(c -> c.getId() == campanha.getIdCampanha()).findFirst();
		
			encontrado.orElse(null);
				newCampanhasUsuario.add(campanha);
		}
		
		return salvarCampanhasUsuarios(newCampanhasUsuario);		
	}
}
