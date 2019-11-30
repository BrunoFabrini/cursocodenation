package com.br.codenation.aplicacao.core;

public class Result {
	
	private String message = "";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean success() {
		return message == "";
	}
	
	public Result() {
		
	}
	
	public Result(String message) {
		this.message = message;
	}

	public Result(Exception ex) {
		this.message = "Ocorreu um erro inesperado. Detalhes: " + ex.getMessage();
	}
}

