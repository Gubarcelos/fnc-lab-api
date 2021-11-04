package br.com.fnc.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import br.com.fnc.dtos.ExameDTO;
import br.com.fnc.services.ExameService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/exames") // classe para busca GET de exame
public class ExameResource {

	@Autowired
	private ExameService service;

	
	// Metodo padrão DTO: para listar apenas os pacientes
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExameDTO> findById(@PathVariable Integer id){
		
		ExameDTO obj = new ExameDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
		//localhost:8080/exames?pacientes=1
	}
	
	@GetMapping
	public ResponseEntity<List<ExameDTO>> findAll(){
		List<ExameDTO> list =service.findAll().stream().map(obj -> new ExameDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<ExameDTO> create(@RequestBody ExameDTO obj){
		obj = new ExameDTO(service.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping
	public ResponseEntity<ExameDTO> update(@Valid @RequestBody ExameDTO obj){
		obj = new ExameDTO(service.update(obj));
		return ResponseEntity.ok().body(obj);
	}
	
	//Metodo delete
		@DeleteMapping(value ="/{id}") 
		public ResponseEntity<Void> delete(@PathVariable Integer id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
								
		
}
