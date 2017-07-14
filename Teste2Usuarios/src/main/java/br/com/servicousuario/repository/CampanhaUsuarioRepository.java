package br.com.servicousuario.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.servicousuario.model.CampanhaUsuario;

public interface CampanhaUsuarioRepository  extends CrudRepository<CampanhaUsuario, Long>{
	
	List<CampanhaUsuario> findCampanhaByUsuario(@Param("idUsuario") Long idUsuario);
	
}
