package br.com.fnc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fnc.domain.Exame;



@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer>{

	@Query("SELECT obj FROM Exame obj WHERE obj.paciente.id = id_pc ORDER by paciente")
	List<Exame> findAllbyPaciente(@Param(value = "id_pc")Integer id_pc);
	
	
}
