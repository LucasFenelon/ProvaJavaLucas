package br.com.servicousuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name="campanhausuario")
@NamedQuery(name="campanhausuario.findCampanhaByUsuario",
				query="SELECT cu FROM campanhausuario cu WHERE cu.idUsuario = :idUsuario")
public class CampanhaUsuario {
	
	public CampanhaUsuario() {
		super();
	}

	public CampanhaUsuario(Long idCampanha, Long idUsuario) {
		super();
		this.idCampanha = idCampanha;
		this.idUsuario = idUsuario;
	}

	@Id
	@GeneratedValue
	@Column(name="IDCAMPANHAUSUARIO")
	private Long id;
	
	@Column(name="IDCAMPANHA")
	private Long idCampanha;
	
	@Column(name="IDUSUARIO")
	private Long idUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(Long idCampanha) {
		this.idCampanha = idCampanha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}
