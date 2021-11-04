package br.com.fnc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fnc.domain.Procedimento;





@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer>{

	@Query("SELECT obj FROM Procedimento obj WHERE obj.exame.id = id_ex")
	List<Procedimento> findAllbyPaciente(@Param(value ="id_ex")Integer id_ex);
	
	
}
