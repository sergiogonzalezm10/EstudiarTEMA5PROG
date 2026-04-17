package domotica;

public class Camara extends Dispositivo implements Alertable {

	private String resolucion;
	private boolean grabando;
	private boolean alertaActiva;	
	private String mensajeAlerta;
	
	
	public Camara(String nombre, String marca, double precio, String resolucion) {
		super(nombre, marca, precio);
		this.resolucion = resolucion;
		this.grabando = false;
		this.alertaActiva = false;
		this.mensajeAlerta = "";
	}
	
	public String getResolucion() {
		return resolucion;
	}
	
	public boolean isGrabando() {
		return grabando;
	}
	
	public void iniciarGrabacion() {
		if(!isEncendido()) throw new DispositivoApagadoException();
		this.grabando = true;
	}
	
	public void detenerGrabacion() {
		this.grabando = false;
	}
	
	public void activarAlerta(String mensaje) {
		if(!isEncendido()) throw new DispositivoApagadoException();
		this.alertaActiva = true;
		this.mensajeAlerta = mensaje;
	}

	public void desactivarAlerta() {
		if(!isEncendido()) throw new DispositivoApagadoException();
		this.alertaActiva = false;
		this.mensajeAlerta = "";
	}
	
	public boolean hayAlerta() {
		return alertaActiva;
	}
	
	public String getMensajeAlerta() {
		return mensajeAlerta;
	}
	
	
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
