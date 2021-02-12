package com.trabalho.lp3;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.trabalho.lp3.Application;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public VeterinarioRepository run(VeterinarioRepository vt) {
		Veterinario vt1 = new Veterinario();
		vt1.setCpf("0431722051");
		vt1.setDataNasc(new Date(System.currentTimeMillis()));
		vt1.setNome("Joao");
		vt1.setTempoExperiencia("5 anos");
		vt1 = vt.save(vt1);

		Calendar c = Calendar.getInstance();

		Paciente p = new Paciente();
		p.setNome("kiko");
		p.setEspecie("Cachorro");
		p.setIdade(2);
		p.setTutor("Paulo");

		Atendimento at1 = new Atendimento();
		at1.setDataHora(c.getTime());
		at1.setObservacoes("paciente está com bastante dor, dar prioridade.");
		at1.setValor((float) 10.15);
		at1.setPaciente(p);

		vt1.getAtendimentos().add(at1);

		return vt;
	}

	/*
	 * @Bean public PacienteRepository run(PacienteRepository pac) { return pac; }
	 */
}
