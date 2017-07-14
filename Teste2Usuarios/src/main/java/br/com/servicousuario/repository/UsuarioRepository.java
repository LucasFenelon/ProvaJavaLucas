package br.com.servicousuario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.servicousuario.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findUsuarioByEmail(@Param("email") String email);

}
