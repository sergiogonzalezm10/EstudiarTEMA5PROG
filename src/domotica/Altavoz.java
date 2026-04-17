package domotica;

public class Altavoz extends Dispositivo implements Ajustable {


	private String asistente;
	private int volumen;
	private static final int VOLUMEN_DEFAULT = 30;
	private static final int PASO_VOLUMEN = 5;
	private static final int MAX_VOLUMEN = 100;
	private static final int MIN_VOLUMEN = 0;
	
	
	public Altavoz(String nombre, String marca, double precio, String asistente) {
		super(nombre, marca, precio);
		this.asistente = asistente;
		this.volumen = VOLUMEN_DEFAULT;
	}
	
	

	
	public String getAsistente() {
		return asistente;
	}

	
	public int getVolumen() {
		return volumen;
	}
	
	
	public void subirNivel() {
		if(!isEncendido()) throw new DispositivoApagadoException();
		volumen = Math.min(volumen + PASO_VOLUMEN, MAX_VOLUMEN  );
	}
	
	public void bajarNivel() {
		if(!isEncendido()) throw new DispositivoApagadoException();
		volumen = Math.max(volumen - PASO_VOLUMEN, MIN_VOLUMEN  );
	}
	
	public String toString() {
		return  "Altavoz [" +
				"nombre=" + getNombre() +
                ", marca=" + getMarca() +
                ", precio=" + getPrecio() + "€" +
                ", encendido=" + isEncendido() +
                ", asistente=" + asistente +
                ", volumen=" + volumen +
                "]";
    }
	
}