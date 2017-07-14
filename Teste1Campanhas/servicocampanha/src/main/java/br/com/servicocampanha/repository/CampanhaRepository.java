package br.com.servicocampanha.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.servicocampanha.model.Campanha;

public interface CampanhaRepository extends CrudRepository<Campanha, Long>{
	
	List<Campanha> findByDataVigencia(@Param("dataVigencia") Date dataVigencia);

}
