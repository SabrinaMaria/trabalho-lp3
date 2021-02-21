package com.trabalho.lp3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
	List<Atendimento> findByValorBetween(Float min, Float max);
	List<Atendimento> findByObservacoes(String observacoes);
}
