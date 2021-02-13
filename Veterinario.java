package com.trabalho.lp3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVeterinario;
	private Date dataNasc;
	private String nome;
	private Integer tempoExperiencia;
	private String cpf;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Atendimento> atendimentos; 
	
	public Veterinario() {
		this.atendimentos = new ArrayList<Atendimento>();
	}
	
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}
	
	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
	
	public Integer getIdVeterinario() {
		return idVeterinario;
	}
	
	public void setIdVeterinario(Integer idVeterinario) {
		this.idVeterinario = idVeterinario;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getTempoExperiencia() {
		return tempoExperiencia;
	}
	
	public void setTempoExperiencia(Integer tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return this.nome + ", " + this.tempoExperiencia + " anos de experiência";
	}
}