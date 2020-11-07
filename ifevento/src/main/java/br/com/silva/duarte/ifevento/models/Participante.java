package br.com.silva.duarte.ifevento.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;




@Entity
public class Participante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idParticipante;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private Date dataNascimento;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "evento_participantes", joinColumns = @JoinColumn(referencedColumnName  = "idParticipante"),
	inverseJoinColumns = @JoinColumn(referencedColumnName  = "IDEvento"))
	private Set<Evento> eventos;
	
	
	public long getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(long idParticipante) {
		this.idParticipante = idParticipante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	

}
