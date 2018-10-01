package es.upm.miw.masterMind.models;

public enum Color {
	AMARILLO('A'),
	ROJO('R'),
	VERDE('V'),
	AZUL('Z'),
	BLANCO('B'),
	NEGRO('N')
	;

    private char value;

	Color(char value){ this.value = value; }

	public String toString(){
		return ""+this.value;
	}

	public boolean areEquals(char caracter){
	    return this.value == caracter;
	}
}