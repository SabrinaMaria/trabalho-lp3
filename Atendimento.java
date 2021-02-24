package com.trabalho.lp3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAtendimento;
	private Date data;
	private String horario;
	private Float valor;
	private String observacoes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_paciente", referencedColumnName="idPaciente")
	private Paciente paciente;
	
	@ManyToMany(mappedBy="atendimentos", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Veterinario> veterinarios;
	
	public Atendimento() {
		this.veterinarios = new ArrayList<Veterinario>();
	}

	public Integer getIdAtendimento() {
		return idAtendimento;
	}

	public List<Veterinario> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(List<Veterinario> veterinarios) {
		this.veterinarios = veterinarios;
	}

	public void setIdAtendimento(Integer idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@Override
	public String toString() {
		return this.data.toString().substring(0, 9) + " " + this.horario + " - " + this.observacoes;
	}
}
