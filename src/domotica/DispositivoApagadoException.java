package domotica;
 
/**
 * Excepción que se lanza cuando se intenta realizar una operación
 * que requiere que el dispositivo esté encendido, pero este se
 * encuentra apagado.
 */
public class DispositivoApagadoException extends RuntimeException {
 
    /**
     * Crea una excepción con el mensaje estándar de dispositivo apagado.
     */
    public DispositivoApagadoException() {
        super("Error: el dispositivo está apagado.");
    }
}
 