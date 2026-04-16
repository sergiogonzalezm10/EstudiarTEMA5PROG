package domotica;

public interface Alertable{


	/*
	 * Activa una alerta en el dispositivo con el mensaje proporcionado
	 */
	void activarAlerta(String mensaje);
	
	
	/**
	 * Desactiva alerta en el dispositivo
	 */
	void desactivarAlerta(String mensaje);
	
	void hayAlerta();
}
