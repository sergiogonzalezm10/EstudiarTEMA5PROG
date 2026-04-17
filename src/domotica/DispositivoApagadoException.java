package domotica;

/*
 * Excepción que se lanza cuando se realiza una acción, cuando el dispositivo debe estar 
 * encendido y está apagado.
 */
public class DispositivoApagadoException extends RuntimeException {
	
/**
 * Excepcion que muestra el mensaje de que el dispositivo está apagado
 */
 public DispositivoApagadoException() {
	 super("Error: El dispositivo está apagado");
 }
 
}
