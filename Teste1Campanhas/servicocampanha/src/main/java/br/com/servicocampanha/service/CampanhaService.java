package br.com.servicocampanha.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.servicocampanha.model.Campanha;
import br.com.servicocampanha.repository.CampanhaRepository;

@Service
public class CampanhaService {
	
	@Autowired
	private CampanhaRepository campanhaRepository;
		
	public Iterable<Campanha> listaCampanha(){
		return campanhaRepository.findAll();
	}
	
	public Campanha getCampanha(Long id){
		return campanhaRepository.findOne(id);
	}
	
	public Iterable<Campanha> salvaCampanha(Campanha campanha){
		List<Campanha> campanhas = campanhaRepository.findByDataVigencia(campanha.getDataVigencia());
		
		if(campanhas.size() > 0){
			campanhas.stream().forEach(camp -> adicionaDiasVigenciaCampanha(camp, campanhas.size() - campanhas.indexOf(camp)));
			campanhaRepository.save(campanhas);
		}
		
		campanhaRepository.save(campanha);		
		return campanhaRepository.findAll();
	}
	
	public Iterable<Campanha> removeCampanha(Long id){
		if(getCampanha(id) != null){
			campanhaRepository.delete(id);
		}
		
		return campanhaRepository.findAll();
	}
	
	private void adicionaDiasVigenciaCampanha(Campanha campanha, int diasAMais){
		campanha.setDataVigencia(new Date(campanha.getDataVigencia().getTime() + (diasAMais * 86400000)));
	}
}
