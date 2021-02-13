package com.trabalho.lp3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	List<Paciente> findByTutor(String tutor);
	List<Paciente> findByEspecie(String especie);
}
