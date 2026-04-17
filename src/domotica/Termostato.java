package domotica;

public class Termostato extends Dispositivo implements Alertable {

	private double temperaturaObjetivo;
	private String modo;
	private boolean alertaActiva;
	private String mensajeAlerta;
	
	public Termostato(String nombre, String marca, double precio, double temperaturaObjetivo, String modo) {
		super(nombre, marca, precio);
		this.temperaturaObjetivo = temperaturaObjetivo;
		this.modo = modo;
		this.alertaActiva = false;
		this.mensajeAlerta = "";
	}
	
	public double getTemperaturaObjetivo() {
		return temperaturaObjetivo;
	}
	
	public String getModo() {
		return modo;
	}
	
	public void cambiarModo() {
		modo = modo.equals("CALOR") ? "FRIO" : "CALOR";
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
