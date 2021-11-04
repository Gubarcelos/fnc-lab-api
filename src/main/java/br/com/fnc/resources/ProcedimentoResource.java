package br.com.fnc.resources;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fnc.domain.Procedimento;
import br.com.fnc.dtos.ProcedimentoDTO;
import br.com.fnc.services.ProcedimentoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/procedimentos")  //classe para busca GET de procedimento
public class ProcedimentoResource {
	@Autowired
	private ProcedimentoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Procedimento> findById(@PathVariable Integer id) {
		Procedimento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
		// localhost:8080/exame/id
	}
	
	// Metodo padrão DTO: para listar apenas os pacientes
	@GetMapping
	public ResponseEntity<List<ProcedimentoDTO>>findAll(@RequestParam(value = "exames", defaultValue = "0")Integer id_ex){
		
		List<Procedimento> list = service.findAll(id_ex);
		List<ProcedimentoDTO> listDTO = list.stream().map(obj -> new ProcedimentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		//localhost:8080/exames?pacientes=1
	}

}