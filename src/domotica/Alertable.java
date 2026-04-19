package domotica;
 
/**
 * Interfaz que representa la capacidad de gestionar alertas en un dispositivo.
 * Permite activar una alerta con un mensaje, desactivarla e informar si existe
 * una alerta activa en ese momento.
 * 
 * Activar y desactivar una alerta requiere que el dispositivo esté encendido.
 * 
 */
public interface Alertable {
 
    /**
     * Activa una alerta en el dispositivo con el mensaje proporcionado.
     *
     * @param mensaje el mensaje descriptivo de la alerta
     * @throws DispositivoApagadoException si el dispositivo está apagado
     */
    void activarAlerta(String mensaje);
 
    /**
     * Desactiva la alerta activa del dispositivo.
     *
     * @throws DispositivoApagadoException si el dispositivo está apagado
     */
    void desactivarAlerta();
 
    /**
     * Indica si hay una alerta activa en el dispositivo.
     *
     * @return {@code true} si hay una alerta activa, {@code false} en caso contrario
     */
    boolean hayAlerta();
}
 