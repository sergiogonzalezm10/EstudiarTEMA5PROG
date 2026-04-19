package domotica;
 
/**
 * Representa una cámara de seguridad inteligente del catálogo domótico.
 * 
 * Almacena la resolución e indica si está grabando. Se puede iniciar y
 * detener la grabación; iniciarla requiere que el dispositivo esté encendido.
 * También gestiona alertas: permite activarlas con un mensaje y desactivarlas,
 * operaciones que también requieren que el dispositivo esté encendido.
 * 
 */
public class Camara extends Dispositivo implements Alertable {
 
    /** Resolución de la cámara (por ejemplo "1080p", "4K"). */
    private String resolucion;
 
    /** Indica si la cámara está grabando actualmente. */
    private boolean grabando;
 
    /** Indica si hay una alerta activa. */
    private boolean alertaActiva;
 
    /** Mensaje asociado a la alerta activa. */
    private String mensajeAlerta;
 
    /**
     * Crea una cámara de seguridad con los datos proporcionados.
     * Se inicializa sin grabar y sin alerta activa.
     *
     * @param nombre     el nombre comercial de la cámara
     * @param marca      la marca de la cámara
     * @param precio     el precio de la cámara
     * @param resolucion la resolución de la cámara
     */
    public Camara(String nombre, String marca, double precio, String resolucion) {
        super(nombre, marca, precio);
        this.resolucion = resolucion;
        this.grabando = false;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }
 
    /**
     * Devuelve la resolución de la cámara.
     *
     * @return la resolución de la cámara
     */
    public String getResolucion() {
        return resolucion;
    }
 
    /**
     * Indica si la cámara está grabando actualmente.
     *
     * @return {@code true} si está grabando, {@code false} en caso contrario
     */
    public boolean isGrabando() {
        return grabando;
    }
 
    /**
     * Inicia la grabación de la cámara.
     *
     * @throws DispositivoApagadoException si la cámara está apagada
     */
    public void iniciarGrabacion() {
        if (!isEncendido()) throw new DispositivoApagadoException();
        this.grabando = true;
    }
 
    /**
     * Detiene la grabación de la cámara.
     */
    public void detenerGrabacion() {
        this.grabando = false;
    }
 
    /**
     * Activa una alerta en la cámara con el mensaje proporcionado.
     *
     * @param mensaje el mensaje descriptivo de la alerta
     * @throws DispositivoApagadoException si la cámara está apagada
     */
    @Override
    public void activarAlerta(String mensaje) {
        if (!isEncendido()) throw new DispositivoApagadoException();
        this.alertaActiva = true;
        this.mensajeAlerta = mensaje;
    }
 
    /**
     * Desactiva la alerta activa de la cámara.
     *
     * @throws DispositivoApagadoException si la cámara está apagada
     */
    @Override
    public void desactivarAlerta() {
        if (!isEncendido()) throw new DispositivoApagadoException();
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }
 
    /**
     * Indica si hay una alerta activa en la cámara.
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
     * Devuelve una representación en cadena con toda la información de la cámara.
     *
     * @return cadena con nombre, marca, precio, estado, resolución, grabación y alerta
     */
    @Override
    public String toString() {
        return "Camara [" +
                "nombre=" + getNombre() +
                ", marca=" + getMarca() +
                ", precio=" + getPrecio() + "€" +
                ", encendido=" + isEncendido() +
                ", resolucion=" + resolucion +
                ", grabando=" + grabando +
                ", alertaActiva=" + alertaActiva +
                ", mensajeAlerta=" + mensajeAlerta +
                "]";
    }
}