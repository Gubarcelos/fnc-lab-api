package br.com.fnc.resources.exceptions;

//Classe para menssagem de erros
public class StandardError {

	private long timestamp;
	private Integer status;
	private String messager;

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(long timestamp, Integer status, String messager) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.messager = messager;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessager() {
		return messager;
	}

	public void setMessager(String messager) {
		this.messager = messager;
	}

}
