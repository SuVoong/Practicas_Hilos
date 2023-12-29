package hilos;

import clases.Contador;
/**
 * @author SuShan Voong Sun
 */
import clases.Playa;

public class TipoBarco extends Thread {
	private Playa isla;
	private int capacidad;
	private String nombre;
	private boolean fin;
	private int num;
	private Contador cont;

	/**
	 * El constructor TipoBarco recibe el nombre y recibe la isla
	 * 
	 * @param nombre    Recoge un String que se usara para indentificar si es lancha
	 *                  o bote salvavidas
	 * @param isla      La clase que tiene en comun con los demas hilos.
	 * @param prioridad Recoge la prioridad que tiene el hilo, a la hora de salir
	 */

	public TipoBarco(String nombre, Playa isla, int num, int prioridad) {
		this.nombre = nombre;
		this.isla = isla;
		this.num = num;
		capacidad = 0;
		this.cont = new Contador();
		this.setPriority(prioridad);
		fin = false;
	}

	/**
	 * El constructor TipoBarco recibe el nombre y recibe la isla
	 * 
	 * @param nombre Recoge un String que se usara para indentificar si es lancha o
	 *               bote salvavidas
	 * @param isla   La clase que tiene en comun con los demas hilos.
	 */

	public TipoBarco(String nombre, Playa isla, int num) {
		this.nombre = nombre;
		this.isla = isla;
		this.num = num;
		capacidad = 0;
		this.cont = new Contador();
		fin = false;
	}

	/**
	 * Este metodo capacidad() de pendiendo si es lancha o bote salvavidas indicara
	 * cuantas personas entran.
	 */

	public void capacidad() {
		int num = 0;
		if (nombre.equalsIgnoreCase("lanchas")) {
			num = 100 + (int) (Math.random() * (200 - 100));
			this.capacidad = num;
		} else if (nombre.equalsIgnoreCase("bote salvavidas")) {
			num = 300 + (int) (Math.random() * (400 - 300));
			this.capacidad = num;
		}
	}

	/**
	 * - El metodo run() hace empezar el hilo, no termina hasta que es interrumpido.
	 * interrumpe cuando el hilo de la clase ContadorDias ha terminado.
	 * 
	 * - Cuando funciona, utiliza los metodos de isla 
	 *   1. Con isla.semaforo(), el tiempo que llega ha embarcar 
	 *   2. Con isla.rescatar(nombre, capacidad), le damos cuantas personas llegan a entrar y que vehículo rescata 
	 *   3. Con isla.semaforo(), el tiempo que llega ha desembarcar en el Barco AltaMar 
	 *   4. Con isla.desembarcar(nombre, capacidad) cuantas personas han embarcado en el Barco AltaMar
	 * 
	 */

	public void run() {
		while (!fin) {
			capacidad();
			try {
				isla.semaforo(400);
				isla.rescatar(nombre, capacidad, num, cont);
				isla.semaforo(500);
				isla.desembarcar(nombre, capacidad, num, cont); 
			} catch (InterruptedException e) {
				fin = true;		
			}
		}
		System.out.println(nombre.toUpperCase() +" "+num+" ha rescatado "+cont.getCont());
	}
}
