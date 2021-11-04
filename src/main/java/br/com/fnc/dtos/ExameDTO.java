package br.com.fnc.dtos;

import java.io.Serializable;



import br.com.fnc.domain.Exame;


public class ExameDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer paciente;
	private String dataColeta;
	private String dataResultado;
	
	
	public ExameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExameDTO(Exame obj) {
		super();
		this.id = obj.getId();
		this.paciente = obj.getPaciente().getId();
		this.dataColeta = obj.getDataColeta();
		this.dataResultado = obj.getDataResultado();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPaciente() {
		return paciente;
	}
	public void setPaciente(Integer paciente) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	



	
}
