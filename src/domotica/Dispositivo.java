
package domotica;
 
import java.util.Objects;
 
/**
 * Clase abstracta que representa un dispositivo inteligente del hogar.
 * 
 * Todos los dispositivos comparten nombre comercial, marca, precio y un
 * indicador de si están encendidos o apagados. El indicador parte siempre
 * en apagado.
 * 
 * Dos dispositivos se consideran el mismo producto si coinciden en nombre
 * comercial y marca. El orden natural de los dispositivos es por precio
 * de forma creciente.
 * 
 */
public abstract class Dispositivo implements Comparable<Dispositivo> {
 
    /** Nombre comercial del dispositivo. */
    private String nombre;
 
    /** Marca del dispositivo. */
    private String marca;
 
    /** Precio del dispositivo. */
    private double precio;
 
    /** Indica si el dispositivo está encendido ({@code true}) o apagado ({@code false}). */
    private boolean encendido;
 
    /**
     * Crea un nuevo dispositivo con los datos básicos proporcionados.
     * El dispositivo se crea en estado apagado.
     *
     * @param nombre el nombre comercial del dispositivo
     * @param marca  la marca del dispositivo
     * @param precio el precio del dispositivo
     */
    public Dispositivo(String nombre, String marca, double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.encendido = false;
    }
 
    /**
     * Enciende el dispositivo.
     */
    public void encender() {
        this.encendido = true;
    }
 
    /**
     * Apaga el dispositivo.
     */
    public void apagar() {
        this.encendido = false;
    }
 
    /**
     * Indica si el dispositivo está encendido.
     *
     * @return {@code true} si está encendido, {@code false} si está apagado
     */
    public boolean isEncendido() {
        return encendido;
    }
 
    /**
     * Devuelve el nombre comercial del dispositivo.
     *
     * @return el nombre del dispositivo
     */
    public String getNombre() {
        return nombre;
    }
 
    /**
     * Devuelve la marca del dispositivo.
     *
     * @return la marca del dispositivo
     */
    public String getMarca() {
        return marca;
    }
 
    /**
     * Devuelve el precio del dispositivo.
     *
     * @return el precio del dispositivo
     */
    public double getPrecio() {
        return precio;
    }
 
    /**
     * Compara este dispositivo con otro por precio de forma creciente.
     *
     * @param otro el dispositivo con el que comparar
     * @return un valor negativo, cero o positivo si este dispositivo es
     *         más barato, igual o más caro que el otro
     */
    @Override
    public int compareTo(Dispositivo otro) {
        return Double.compare(this.precio, otro.precio);
    }
 
    /**
     * Determina si este dispositivo es igual a otro objeto.
     * Dos dispositivos son el mismo producto si coinciden en nombre y marca.
     *
     * @param obj el objeto con el que comparar
     * @return {@code true} si tienen el mismo nombre y marca
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Dispositivo)) return false;
        Dispositivo otro = (Dispositivo) obj;
        return Objects.equals(nombre, otro.nombre) && Objects.equals(marca, otro.marca);
    }
 
    /**
     * Devuelve el código hash del dispositivo basado en nombre y marca.
     *
     * @return el código hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, marca);
    }
 
    /**
     * Devuelve una representación en cadena de texto del dispositivo
     * con toda su información.
     *
     * @return cadena con los datos del dispositivo
     */
    @Override
    public abstract String toString();
}