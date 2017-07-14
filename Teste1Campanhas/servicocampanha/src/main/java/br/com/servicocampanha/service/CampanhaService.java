package br.com.servicocampanha.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.servicocampanha.model.Campanha;
import br.com.servicocampanha.repository.CampanhaVigenciaRepository;

@Service
public class CampanhaService {
	
	@Autowired
	private CampanhaVigenciaRepository campanhaVigenciaRepository;
		
	public Iterable<Campanha> listaCampanha(){
		return campanhaVigenciaRepository.findAll();
	}
	
	public Campanha getCampanha(Long id){
		return campanhaVigenciaRepository.findOne(id);
	}
	
	public Iterable<Campanha> salvaCampanha(Campanha campanha){
		List<Campanha> campanhas = campanhaVigenciaRepository.findByDataVigencia(campanha.getDataVigencia());
		
		if(campanhas.size() > 0){
			campanhas.stream().forEach(camp -> adicionaDiasVigenciaCampanha(camp, campanhas.size() - campanhas.indexOf(camp)));
			campanhaVigenciaRepository.save(campanhas);
		}
		
		campanhaVigenciaRepository.save(campanha);		
		return campanhaVigenciaRepository.findAll();
	}
	
	public Iterable<Campanha> removeCampanha(Long id){
		if(getCampanha(id) != null){
			campanhaVigenciaRepository.delete(id);
		}
		
		return campanhaVigenciaRepository.findAll();
	}
	
	private void adicionaDiasVigenciaCampanha(Campanha campanha, int diasAMais){
		campanha.setDataVigencia(new Date(campanha.getDataVigencia().getTime() + (diasAMais * 86400000)));
	}
}
