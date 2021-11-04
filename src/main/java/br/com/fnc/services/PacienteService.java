package br.com.fnc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.fnc.domain.Paciente;
import br.com.fnc.dtos.PacienteDTO;
import br.com.fnc.repositories.PacienteRepository;
import br.com.fnc.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	// faz a busca da categoria pelo ID
	public Paciente findById(Integer id) {

		
		Optional<Paciente> obj = repository.findById(id); // passa menssagem de erro quando não encontra o objeto
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + id + ",tipo: " + Paciente.class.getName()));

	}
	
	public List<Paciente> findAll(){
		
		return repository.findAll();
	}
	
	public Paciente create(Paciente obj) {
		//nulo para o jpa não interpretar como atualização
		obj.setId(null);
		return repository.save(obj);
	}

	public Paciente update(Integer id, PacienteDTO objDto) {
		//verificar se o paciente existe
		Paciente obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setCpf(objDto.getCpf());
		obj.setEmail(objDto.getEmail());
		return repository.save(obj);
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
}
