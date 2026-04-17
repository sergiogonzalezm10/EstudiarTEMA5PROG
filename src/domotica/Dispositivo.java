package domotica;
import java.util.Objects;

public abstract class Dispositivo implements Comparable<Dispositivo> {

	private String nombre;
	private String marca;
	private double precio;
	private boolean encendido;
	
	public Dispositivo(String nombre, String marca, double precio) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.encendido = false;
	}
	
	public void encender() {
		this.encendido = true;
	}
	
	public void apagar() {
		this.encendido = false;
	}
	
	
	boolean isEncendido() {
		return encendido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int compareTo(Dispositivo otro) {
		return Double.compare(this.precio, otro.precio);
	}
	
	public boolean equals(Object obj) {
	if ( this == obj) return true;
	if(!(obj instanceof Dispositivo)) return false;
	Dispositivo otro = (Dispositivo) obj;
	return Objects.equals(nombre,otro.nombre) && Objects.equals(marca, otro.marca);
	}
	
	public int hashCode() {
		return Objects.hash(nombre,marca);
	}
	
	public abstract String toString();
	
	}

