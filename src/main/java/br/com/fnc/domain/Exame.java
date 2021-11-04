package br.com.fnc.domain;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exame implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //indica a cahve primaria 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gera a chave primaria
	private Integer id;
	
	@JsonIgnore
	@ManyToOne//relaciona com pacientes
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private String dataColeta;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private String dataResultado;
	
	@OneToMany(mappedBy = "exame") //relaciona com exames
	private List<Procedimento> procedimentos = new ArrayList<>();

	public Exame() {
		super();
		
	}

	public Exame(Integer id, Paciente paciente, String dataColeta, String dataResultado) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.dataColeta = dataColeta ;
		this.dataResultado = dataResultado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(String dataColeta) {
		this.dataColeta = dataColeta;
	}

	public String getDataResultado() {
		return dataResultado;
	}

	public void setDataResultado(String dataResultado) {
		this.dataResultado = dataResultado;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
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
		Exame other = (Exame) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
