package com.trabalho.lp3;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	private String nome;
	private String tutor;
	private String especie;
	private Integer idade;
	private String periodo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="paciente")
	private List<Atendimento> atendimentos;
 	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTutor() {
		return tutor;
	}
	
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String getPeriodo() {
		return this.periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}
	
	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
	
	@Override
	public String toString() {
		return this.nome + " (" + this.especie + ")" + ", " + this.idade + " " + this.periodo + " - " + this.tutor;
	}
}
