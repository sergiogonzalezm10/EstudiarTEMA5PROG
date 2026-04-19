package domotica;
 
/**
 * Representa un altavoz inteligente del catálogo domótico.
 * 
 * Almacena el nombre del asistente de voz y el nivel de volumen,
 * que por defecto es 30. El volumen nunca puede bajar de 0 ni superar 100.
 * Subir el volumen lo incrementa en 5 unidades y bajarlo lo reduce en 5.
 * 
 * Ambas operaciones sobre el volumen requieren que el dispositivo esté encendido.
 * 
 */
public class Altavoz extends Dispositivo implements Ajustable {
 
    /** Nombre del asistente de voz integrado. */
    private String asistente;
 
    /** Nivel de volumen actual. Valor por defecto: 30. */
    private int volumen;
 
    /** Volumen por defecto al crear el altavoz. */
    private static final int VOLUMEN_DEFAULT = 30;
 
    /** Incremento/decremento de volumen por operación. */
    private static final int PASO_VOLUMEN = 5;
 
    /** Volumen mínimo permitido. */
    private static final int VOLUMEN_MIN = 0;
 
    /** Volumen máximo permitido. */
    private static final int VOLUMEN_MAX = 100;
 
    /**
     * Crea un altavoz inteligente con los datos proporcionados.
     * El volumen se inicializa a 30.
     *
     * @param nombre    el nombre comercial del altavoz
     * @param marca     la marca del altavoz
     * @param precio    el precio del altavoz
     * @param asistente el nombre del asistente de voz integrado
     */
    public Altavoz(String nombre, String marca, double precio, String asistente) {
        super(nombre, marca, precio);
        this.asistente = asistente;
        this.volumen = VOLUMEN_DEFAULT;
    }
 
    /**
     * Devuelve el nombre del asistente de voz del altavoz.
     *
     * @return el nombre del asistente
     */
    public String getAsistente() {
        return asistente;
    }
 
    /**
     * Devuelve el nivel de volumen actual del altavoz.
     *
     * @return el volumen actual (entre 0 y 100)
     */
    public int getVolumen() {
        return volumen;
    }
 
    /**
     * Sube el volumen en 5 unidades, sin superar el máximo de 100.
     *
     * @throws DispositivoApagadoException si el altavoz está apagado
     */
    @Override
    public void subirNivel() {
        if (!isEncendido()) throw new DispositivoApagadoException();
        volumen = Math.min(volumen + PASO_VOLUMEN, VOLUMEN_MAX);
    }
 
    /**
     * Baja el volumen en 5 unidades, sin bajar del mínimo de 0.
     *
     * @throws DispositivoApagadoException si el altavoz está apagado
     */
    @Override
    public void bajarNivel() {
        if (!isEncendido()) throw new DispositivoApagadoException();
        volumen = Math.max(volumen - PASO_VOLUMEN, VOLUMEN_MIN);
    }
 
    /**
     * Devuelve una representación en cadena con toda la información del altavoz.
     *
     * @return cadena con nombre, marca, precio, estado, asistente y volumen
     */
    @Override
    public String toString() {
        return "Altavoz [" +
                "nombre=" + getNombre() +
                ", marca=" + getMarca() +
                ", precio=" + getPrecio() + "€" +
                ", encendido=" + isEncendido() +
                ", asistente=" + asistente +
                ", volumen=" + volumen +
                "]";
    }
}
 