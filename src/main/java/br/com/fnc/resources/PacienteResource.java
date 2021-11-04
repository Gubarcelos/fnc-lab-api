package br.com.fnc.resources;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fnc.domain.Paciente;
import br.com.fnc.dtos.PacienteDTO;
import br.com.fnc.services.PacienteService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/pacientes")  //classe para busca GET de pacientes
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Paciente> findById(@PathVariable Integer id){
		Paciente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	//localhost:8080/pacientes/id	
	
	//Metodo padrão DTO: para listar apenas os pacientes
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findAll(){
		
		List<Paciente> list = service.findAll();	
		List<PacienteDTO> listDTO = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDTO);
	}
	
	//metodo create
	@PostMapping  //http post
	public ResponseEntity<Paciente> create(@RequestBody Paciente obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Metodo update
	@PutMapping(value ="/{id}")               //definição do path por tipo de parametro
	public ResponseEntity<PacienteDTO> update(@PathVariable Integer id ,@RequestBody PacienteDTO objDto){
		Paciente newObj = service.update(id,objDto);
		return ResponseEntity.ok().body(new PacienteDTO(newObj));
	}
	
	//Metodo delete
	@DeleteMapping(value ="/{id}") 
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
