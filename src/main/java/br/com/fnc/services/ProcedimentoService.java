package br.com.fnc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fnc.domain.Exame;
import br.com.fnc.domain.Procedimento;
import br.com.fnc.repositories.ProcedimentoRepository;
import br.com.fnc.services.exceptions.ObjectNotFoundException;

@Service
public class ProcedimentoService {
	@Autowired
	private ProcedimentoRepository repository;
	@Autowired
	private ProcedimentoService procedimentoService;
	
	// faz a busca da categoria pelo ID
		public Procedimento findById(Integer id) {

			
			Optional<Procedimento> obj = repository.findById(id); // passa menssagem de erro quando não encontra o objeto
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! " + id + ",tipo: " + Exame.class.getName()));

		}
		public List<Procedimento> findAll(Integer id_ex) {

			procedimentoService.findById(id_ex);
			return repository.findAllbyPaciente(id_ex);
		}
}
