package domotica;

public class Luz extends Dispositivo implements Ajustable {
		private String color;
		private int brillo;
		private static final int BRILLO_DEFAULT = 50;
		private static final int PASO_BRILLO = 10;
		private static final int MAX_BRILLO = 100;
		private static final int MIN_BRILLO = 0;
		
		
		public Luz(String nombre, String marca, double precio, String color) {
			super(nombre,marca,precio);
			this.color = color;
			this.brillo = BRILLO_DEFAULT;
 }
		
		
		public String getColor() {
			return color;
		}
		
		public void setColor(String color) {
			this.color = color;
		}

		public int getBrillo() {
			return brillo;
		}
		
		public void subirNivel() {
			if(!isEncendido()) throw new DispositivoApagadoException();
			brillo = Math.min(brillo + PASO_BRILLO, MAX_BRILLO  );
		}
		
		public void bajarNivel() {
			if(!isEncendido()) throw new DispositivoApagadoException();
			brillo = Math.max(brillo - PASO_BRILLO, MIN_BRILLO  );
		}
		
		public String toString() {
			return  "Luz [" +
					"nombre=" + getNombre() +
	                ", marca=" + getMarca() +
	                ", precio=" + getPrecio() + "€" +
	                ", encendido=" + isEncendido() +
	                ", color=" + color +
	                ", brillo=" + brillo +
	                "]";
	    }
}
