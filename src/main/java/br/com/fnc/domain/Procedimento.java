package br.com.fnc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity//informa que é uma entidade
public class Procedimento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id //indica a cahve primaria 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gera a chave primaria
	private Integer id;
	private String nome;
	private String prazoAnalise;
	
	@JsonIgnore
	@ManyToOne//indica a relação com exames
	@JoinColumn(name = "exame_id") //cria coluna relacionando id
	private Exame exame;

	public Procedimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Procedimento(Integer id, String nome, String prazoAnalise, Exame exame) {
		super();
		this.id = id;
		this.nome = nome;
		this.prazoAnalise = prazoAnalise;
		this.exame = exame;
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

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedimento other = (Procedimento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
