package domotica;
 
/**
 * Representa un termostato inteligente del catálogo domótico.
 * 
 * Controla la temperatura objetivo y el modo de funcionamiento (CALOR/FRIO).
 * El modo puede alternarse en cualquier momento. También gestiona alertas:
 * permite activarlas con un mensaje y desactivarlas.
 * 
 * Las operaciones de alerta y el cambio de modo requieren que el dispositivo
 * esté encendido.
 * 
 */
public class Termostato extends Dispositivo implements Alertable {
 
    /** Temperatura objetivo configurada en el termostato. */
    private double temperaturaObjetivo;
 
    /** Modo de funcionamiento actual: "CALOR" o "FRIO". */
    private String modo;
 
    /** Indica si hay una alerta activa. */
    private boolean alertaActiva;
 
    /** Mensaje asociado a la alerta activa. */
    private String mensajeAlerta;
 
    /**
     * Crea un termostato inteligente con los datos proporcionados.
     * La alerta se inicializa como inactiva.
     *
     * @param nombre               el nombre comercial del termostato
     * @param marca                la marca del termostato
     * @param precio               el precio del termostato
     * @param temperaturaObjetivo  la temperatura objetivo inicial
     * @param modo                 el modo de funcionamiento inicial ("CALOR" o "FRIO")
     */
    public Termostato(String nombre, String marca, double precio,
                      double temperaturaObjetivo, String modo) {
        super(nombre, marca, precio);
        this.temperaturaObjetivo = temperaturaObjetivo;
        this.modo = modo;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }
 
    /**
     * Devuelve la temperatura objetivo configurada.
     *
     * @return la temperatura objetivo
     */
    public double getTemperaturaObjetivo() {
        return temperaturaObjetivo;
    }
 
    /**
     * Devuelve el modo de funcionamiento actual.
     *
     * @return "CALOR" o "FRIO"
     */
    public String getModo() {
        return modo;
    }
 
    /**
     * Alterna el modo de funcionamiento entre "CALOR" y "FRIO".
     */
    public void cambiarModo() {
        modo = modo.equals("CALOR") ? "FRIO" : "CALOR";
    }
 
    /**
     * Activa una alerta en el termostato con el mensaje proporcionado.
     *
     * @param mensaje el mensaje descriptivo de la alerta
     * @throws DispositivoApagadoException si el termostato está apagado
     */
    @Override
    public void activarAlerta(String mensaje) {
        if (!isEncendido()) throw new DispositivoApagadoException();
        this.alertaActiva = true;
        this.mensajeAlerta = mensaje;
    }
 
    /**
     * Desactiva la alerta activa del termostato.
     *
     * @throws DispositivoApagadoException si el termostato está apagado
     */
    @Override
    public void desactivarAlerta() {
        if (!isEncendido()) throw new DispositivoApagadoException();
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }
 
    /**
     * Indica si hay una alerta activa en el termostato.
     *
     * @return {@code true} si hay alerta activa, {@code false} en caso contrario
     */
    @Override
    public boolean hayAlerta() {
        return alertaActiva;
    }
 
    /**
     * Devuelve el mensaje de la alerta activa.
     *
     * @return el mensaje de alerta, o cadena vacía si no hay alerta
     */
    public String getMensajeAlerta() {
        return mensajeAlerta;
    }
 
    /**
     * Devuelve una representación en cadena con toda la información del termostato.
     *
     * @return cadena con nombre, marca, precio, estado, temperatura, modo y alerta
     */
    @Override
    public String toString() {
        return "Termostato [" +
                "nombre=" + getNombre() +
                ", marca=" + getMarca() +
                ", precio=" + getPrecio() + "€" +
                ", encendido=" + isEncendido() +
                ", temperaturaObjetivo=" + temperaturaObjetivo + "°C" +
                ", modo=" + modo +
                ", alertaActiva=" + alertaActiva +
                ", mensajeAlerta=" + mensajeAlerta +
                "]";
    }
}
