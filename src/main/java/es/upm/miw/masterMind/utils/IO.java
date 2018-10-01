package es.upm.miw.masterMind.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IO {

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
			System.in));

	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				this.writeError("de cadena de caracteres");
			}
		} while (!ok);
		return input;
	}

	public char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.length() != 1) {
				this.writeError("caracter");
			} else {
				charValue = input.charAt(0);
				ok = true;
			}
		} while (!ok);
		return charValue;
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	private void writeError(String formato) {
		this.writeln("ERROR DE FORMATO! "
				+ "Introduzca un valor con formato " + formato + ".");
	}

	public void showMenu(){
		this.writeln("1. Partida");
		this.writeln("2. Demo");
	}

	public int readOption(int optionLimit) {
		int input = 0;
		while (input <= 0 || input > optionLimit) {
			this.write("Elija una opcion: ");
			try {
				input = Integer.parseInt(bufferedReader.readLine());
				if(input <= 0 || input > optionLimit){
					this.writeError("Introduzca un valor correcto.");
				}
			} catch (Exception ex) {
				this.writeError("Error al leer la opcion. Introduzca un valor correcto.");
			}
		};

		return input;
	}

    public String readAttempt(int optionLimit, int numberOfAttempt) {

        String input = null;
        boolean ok = false;

        while (!ok) {
            try {
                this.write("Intento "+numberOfAttempt+": [cuatro letras de entre A-amarillo(0), R-rojo(1), V-verde(2), Z-azul(3), B-blanco(4), N-negro(5)]");
                input = bufferedReader.readLine().toUpperCase();
                if(input.length() == optionLimit)
                    ok = true;
                else
                    this.writeln("Escriba un máximo de "+ optionLimit +"caracteres.");
            } catch (Exception ex) {
                this.writeError("Escriba "+ optionLimit +" colores. ");
            }
        };

        return input;
    }
}
