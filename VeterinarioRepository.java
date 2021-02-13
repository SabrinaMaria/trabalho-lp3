package com.trabalho.lp3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
	List<Veterinario> findByNome(String nome);
	List<Veterinario> findByTempoExperienciaBetween(Integer min, Integer max);
}
