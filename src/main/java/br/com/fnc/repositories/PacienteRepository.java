package br.com.fnc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fnc.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	
	
}
