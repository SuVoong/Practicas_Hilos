package hilos;
import clases.BarcoBase;
/**
 * @author SuShan Voong Sun
 */
import clases.Isla;

public class TipoBarco extends Thread {
	private Isla isla;
	private BarcoBase barcoBase;
	private int capacidad;
	private String nombre;
	private boolean fin;

	/**
	 * El constructor TipoBarco recibe el nombre
	 * y recibe la isla
	 * 
	 * @param nombre  Recoge un String que se usara para indentificar si es lancha o bote salvavidas
	 * @param isla   La clase que tiene en comun con los demas hilos.
	 */
	
	public TipoBarco(String nombre, Isla isla, BarcoBase barcoBase) {
		this.nombre = nombre;
		this.isla = isla;
		capacidad = 0;
		fin = false;
		this.barcoBase = barcoBase;
	}
	/**
	 * Este metodo capacidad() de pendiendo si es lancha o bote salvavidas indicara cuantas personas entran.
	 */

	public void capacidad() {
		int num = 0;
		if (nombre.equalsIgnoreCase("lanchas")) {
			num = 500 + (int) (Math.random() * (1000 - 500));
			this.capacidad = num;
		} else if (nombre.equalsIgnoreCase("bote salvavidas")) {
			num = 1500 + (int) (Math.random() * (2000 - 1500));
			this.capacidad = num;
		}
	}
	
	/**
	 *	- El metodo run() hace empezar el hilo, no termina hasta que es interrumpido.
	 *    interrumpe cuando el hilo de la clase ContadorDias ha terminado.
	 *   
	 *  - Cuando funciona, utiliza los metodos de isla
	 *      1. Con isla.trayecto(nombre, capacidad, 1), el tiempo que llega ha embarcar la playa
	 *      2. Con isla.trayecto(nombre, capacidad, 2), el tiempo que llega ha desembarcar en el Barco AltaMar
	 *  
	 */
	
	public void run() {
		while (!fin) {
			capacidad();
			try {
				isla.trayecto();
				isla.rescatar(nombre, capacidad);
				isla.trayecto();
				isla.desembarcar(nombre, capacidad);
			} catch (InterruptedException e) {
				fin = true;
			}
		}
	}
}
