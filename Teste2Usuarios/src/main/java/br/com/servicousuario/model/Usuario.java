package br.com.servicousuario.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="usuario")
@NamedQuery(name="usuario.findUsuarioByEmail",
				query="SELECT u FROM usuario u WHERE u.email = :email")
public class Usuario {
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String email, Long idTimeCoracao, Date dataNasc, Date ativo) {
		super();
		this.id = id;
		this.email = email;
		this.idTimeCoracao = idTimeCoracao;
		this.dataNasc = dataNasc;
		this.ativo = ativo;
	}

	@Id
	@GeneratedValue
	@Column(name="IDUSUARIO")
	private Long id;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="IDTIMECORACAO")
	private Long idTimeCoracao;
	
	@Column(name="DATANASC")
	private Date dataNasc;
	
	@Column(name="ATIVO")
	private Date ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdTimeCoracao() {
		return idTimeCoracao;
	}

	public void setIdTimeCoracao(Long idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Date getAtivo() {
		return ativo;
	}

	public void setAtivo(Date ativo) {
		this.ativo = ativo;
	}
}
