package br.com.servicousuario.model.rest;

import java.sql.Date;

public class CampanhaTo {
	
	public CampanhaTo() {
		super();
	}
	
	public CampanhaTo(Long id, String nomeCampanha, Long idTimeCoracao, Date dataVigencia) {
		super();
		this.id = id;
		this.nomeCampanha = nomeCampanha;
		this.idTimeCoracao = idTimeCoracao;
		this.dataVigencia = dataVigencia;
	}
	
	private Long id;
	private String nomeCampanha;
	private Long idTimeCoracao;
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
