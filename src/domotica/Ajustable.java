package domotica;
 
/**
 * Interfaz que representa la capacidad de subir y bajar un nivel numérico
 * propio de un dispositivo. Puede aplicarse a cualquier tipo de objeto
 * que disponga de dicha funcionalidad.
 * 
 * Ambas operaciones requieren que el dispositivo esté encendido.
 * 
 */
public interface Ajustable {
 
    /**
     * Sube el nivel numérico del dispositivo en la cantidad que le corresponda.
     *
     * @throws DispositivoApagadoException si el dispositivo está apagado
     */
    void subirNivel();
 
    /**
     * Baja el nivel numérico del dispositivo en la cantidad que le corresponda.
     *
     * @throws DispositivoApagadoException si el dispositivo está apagado
     */
    void bajarNivel();
}
 