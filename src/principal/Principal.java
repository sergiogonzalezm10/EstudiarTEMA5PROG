package principal;

import domotica.*;
import java.util.Arrays;

/**
 * Programa principal que ejercita el catálogo de dispositivos domóticos.
 */
public class Principal {

    public static void main(String[] args) {

        Dispositivo[] catalogo = {
            new Altavoz("Echo Dot", "Amazon", 59.99, "Alexa"),
            new Altavoz("Nest Mini", "Google", 49.00, "Google Assistant"),
            new Luz("Hue White", "Philips", 29.99, "Blanco cálido"),
            new Luz("LIFX Mini", "LIFX", 34.99, "Blanco frío"),
            new Termostato("Smart Thermostat", "Tado", 119.99, 21.5, "CALOR"),
            new Camara("Indoor Cam", "Arlo", 89.99, "1080p")
        };
        
        System.out.println("CATÁLOGO ORDENADO POR PRECIO");
        Arrays.sort(catalogo);
        for (Dispositivo d : catalogo) {
            System.out.println(d);
        }
        /**
        System.out.println("\nACCIONES POR DISPOSITIVO");
        for (Dispositivo d : catalogo) {
            d.encender();
            System.out.println("\n--- " + d.getNombre() + " (" + d.getMarca() + ") ---");

            if (d instanceof Altavoz altavoz) {
                try { altavoz.subirNivel(); } catch (DispositivoApagadoException e) { System.out.println(e.getMessage()); }
                try { altavoz.subirNivel(); } catch (DispositivoApagadoException e) { System.out.println(e.getMessage()); }
                System.out.println("Asistente: " + altavoz.getAsistente());

            } else if (d instanceof Luz luz) {
                try { luz.subirNivel(); } catch (DispositivoApagadoException e) { System.out.println(e.getMessage()); }
                luz.setColor("Azul");
                System.out.println("Color cambiado a: " + luz.getColor());

            } else if (d instanceof Termostato termostato) {
                termostato.cambiarModo();
                System.out.println("Modo cambiado a: " + termostato.getModo());
                try { termostato.activarAlerta("Temperatura fuera de rango"); } catch (DispositivoApagadoException e) { System.out.println(e.getMessage()); }

            } else if (d instanceof Camara camara) {
                try { camara.iniciarGrabacion(); } catch (DispositivoApagadoException e) { System.out.println(e.getMessage()); }
                try { camara.activarAlerta("Movimiento detectado"); } catch (DispositivoApagadoException e) { System.out.println(e.getMessage()); }
            }

            System.out.println(d);
        }

        System.out.println("\nPRUEBA DE ERROR: ALTAVOZ APAGADO");
        Altavoz altavozPrueba = new Altavoz("Echo Dot", "Amazon", 59.99, "Alexa");
        altavozPrueba.apagar();
        System.out.println("Intentando subir volumen con el altavoz apagado...");
        try {
            altavozPrueba.subirNivel();
        } catch (DispositivoApagadoException e) {
            System.out.println(e.getMessage());
        }
        */
    }
}