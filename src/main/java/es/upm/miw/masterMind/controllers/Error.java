package es.upm.miw.masterMind.controllers;

public enum Error {
	NOT_EMPTY("El dato esta vacio");

	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
