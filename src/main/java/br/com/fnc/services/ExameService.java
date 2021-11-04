package br.com.fnc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.fnc.domain.Exame;
import br.com.fnc.domain.Paciente;
import br.com.fnc.dtos.ExameDTO;
import br.com.fnc.repositories.ExameRepository;
import br.com.fnc.services.exceptions.ObjectNotFoundException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repository;
	

	
	@Autowired
	private PacienteService pacienteService;
	

	
	// faz a busca da categoria pelo ID
		public Exame findById(Integer id) {

			
			Optional<Exame> obj = repository.findById(id); // passa menssagem de erro quando não encontra o objeto
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! " + id + ",tipo: " + Exame.class.getName()));

		}

		public List<Exame> findAll() {
			return repository.findAll();
			
		}

		public Exame create(ExameDTO obj) {		
			return fromDTO(obj);
		}
		
		
		
		public Exame update(@Valid ExameDTO obj) {
			findById(obj.getId());
			return fromDTO(obj);
		}
		
		//tratamento da excessão banco de dados
		public void delete(Integer id) {
			findById(id);
			try {
			repository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new br.com.fnc.services.exceptions.DataIntegrityViolationException("O objeto não pode ser deletado, pois possui itens associados");
			}
		}

		
		private  Exame fromDTO(ExameDTO obj) {
			Exame newObj = new Exame();
			newObj.setId(obj.getId());
			newObj.setDataColeta(obj.getDataColeta());
			newObj.setDataResultado(obj.getDataResultado());
			
			Paciente pac = pacienteService.findById(obj.getPaciente());
			newObj.setPaciente(pac);
			
			return repository.save(newObj);
		}



}
