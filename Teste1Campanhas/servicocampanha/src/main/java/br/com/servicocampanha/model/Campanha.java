package br.com.servicocampanha.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name="campanha")
@NamedQuery(name="campanha.findByDataVigencia", query="SELECT c FROM campanha c WHERE c.dataVigencia <= :dataVigencia")
public class Campanha {
	
	public Campanha() {
		super();
	}
	
	public Campanha(String nomeCampanha, Long idTimeCoracao, Date dataVigencia) {
		super();
		this.nomeCampanha = nomeCampanha;
		this.idTimeCoracao = idTimeCoracao;
		this.dataVigencia = dataVigencia;
	}
	
	@Id
	@GeneratedValue
	@Column(name="IDCAMPANHA")
	private Long id;
	
	@Column(name="NOMECAMPANHA")
	private String nomeCampanha;
	
	@Column(name="IDTIMECORACAO")
	private Long idTimeCoracao;
	
	@Column(name="DATAVIGENCIA")
	private Date dataVigencia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCampanha() {
		return nomeCampanha;
	}
	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}
	public Long getIdTimeCoracao() {
		return idTimeCoracao;
	}
	public void setIdTimeCoracao(Long idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}
	public Date getDataVigencia() {
		return dataVigencia;
	}
	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}
}
