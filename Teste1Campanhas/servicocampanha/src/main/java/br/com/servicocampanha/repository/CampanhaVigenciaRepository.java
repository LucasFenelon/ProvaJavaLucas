package br.com.servicocampanha.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.servicocampanha.model.Campanha;

@Repository
public interface CampanhaVigenciaRepository extends CrudRepository<Campanha, Long>{
	
	List<Campanha> findByDataVigencia(@Param("dataVigencia") Date dataVigencia);

}
