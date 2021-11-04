package br.com.fnc.dtos;

import br.com.fnc.domain.Procedimento;

public class ProcedimentoDTO {
	private Integer id;
	private String nome;
	private String prazoAnalise;
	
	
	public ProcedimentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ProcedimentoDTO(Procedimento obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.prazoAnalise = obj.getPrazoAnalise();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getPrazoAnalise() {
		return prazoAnalise;
	}


	public void setPrazoAnalise(String prazoAnalise) {
		this.prazoAnalise = prazoAnalise;
	}
	
	
	
}
