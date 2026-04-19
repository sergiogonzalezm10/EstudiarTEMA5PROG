package domotica;
 
/**
 * Representa una luz inteligente del catálogo domótico.
 * 
 * Almacena el color de la luz y su nivel de brillo, que por defecto es 50.
 * El brillo no puede bajar de 0 ni superar 100.
 * Subir el brillo lo incrementa en 10 unidades y bajarlo lo reduce en 10.
 * 
 * Ambas operaciones sobre el brillo requieren que el dispositivo esté encendido.
 * 
 */
public class Luz extends Dispositivo implements Ajustable {
 
    /** Color actual de la luz. */
    private String color;
 
    /** Nivel de brillo actual. Valor por defecto: 50. */
    private int brillo;
 
    /** Brillo por defecto al crear la luz. */
    private static final int BRILLO_DEFAULT = 50;
 
    /** Incremento/decremento de brillo por operación. */
    private static final int PASO_BRILLO = 10;
 
    /** Brillo mínimo permitido. */
    private static final int BRILLO_MIN = 0;
 
    /** Brillo máximo permitido. */
    private static final int BRILLO_MAX = 100;
 
    /**
     * Crea una luz inteligente con los datos proporcionados.
     * El brillo se inicializa a 50.
     *
     * @param nombre el nombre comercial de la luz
     * @param marca  la marca de la luz
     * @param precio el precio de la luz
     * @param color  el color inicial de la luz
     */
    public Luz(String nombre, String marca, double precio, String color) {
        super(nombre, marca, precio);
        this.color = color;
        this.brillo = BRILLO_DEFAULT;
    }
 
    /**
     * Devuelve el color actual de la luz.
     *
     * @return el color de la luz
     */
    public String getColor() {
        return color;
    }
 
    /**
     * Establece un nuevo color para la luz.
     *
     * @param color el nuevo color de la luz
     */
    public void setColor(String color) {
        this.color = color;
    }
 
    /**
     * Devuelve el nivel de brillo actual de la luz.
     *
     * @return el brillo actual (entre 0 y 100)
     */
    public int getBrillo() {
        return brillo;
    }
 
    /**
     * Sube el brillo en 10 unidades, sin superar el máximo de 100.
     *
     * @throws DispositivoApagadoException si la luz está apagada
     */
    @Override
    public void subirNivel() {
        if (!isEncendido()) throw new DispositivoApagadoException();
        brillo = Math.min(brillo + PASO_BRILLO, BRILLO_MAX);
    }
 
    /**
     * Baja el brillo en 10 unidades, sin bajar del mínimo de 0.
     *
     * @throws DispositivoApagadoException si la luz está apagada
     */
    @Override
    public void bajarNivel() {
        if (!isEncendido()) throw new DispositivoApagadoException();
        brillo = Math.max(brillo - PASO_BRILLO, BRILLO_MIN);
    }
 
    /**
     * Devuelve una representación en cadena con toda la información de la luz.
     *
     * @return cadena con nombre, marca, precio, estado, color y brillo
     */
    @Override
    public String toString() {
        return "Luz [" +
                "nombre=" + getNombre() +
                ", marca=" + getMarca() +
                ", precio=" + getPrecio() + "€" +
                ", encendido=" + isEncendido() +
                ", color=" + color +
                ", brillo=" + brillo +
                "]";
    }
}
 