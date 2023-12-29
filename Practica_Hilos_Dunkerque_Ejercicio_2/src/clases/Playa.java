package clases;

/**
 * @author SuShan Voong Sun
 */
import java.util.concurrent.Semaphore;

public class Playa {
	private int personasPlaya;
	private int personasRescatadas;
	private Semaphore semaforo;

	/**
	 * Este es el constructor Playa()
	 * 
	 * @param personasIsla Recibimos cuantas personas hay en la playa
	 */

	public Playa(int personasPlaya) {
		this.personasPlaya = personasPlaya;
		this.personasRescatadas = 0;
		this.semaforo = new Semaphore(7);
	}

	/**
	 * El metodo rescatar(), en el metodo resta cuantas personas estan en la playa
	 * en personasPlaya, y suma cuantas personas han rescatado en
	 * personasRescatadas.
	 * 
	 * @param nombre    Recibe el nombre de vehículo de rescate
	 * @param capacidad Recibe cuantas personas se embarcan en el vehículo de
	 *                  rescate
	 * @param cont      Se utilizara para contar las personas rescatadas de este hilo
	 */
	public void rescatar(String nombre, int capacidad, int num, Contador cont) {
		personasPlaya -= capacidad;
		cont.masCont(capacidad);
		personasRescatadas += capacidad;
		System.out.println("1 - Han embarcado " + capacidad + " soldados de la playa en " + nombre.toUpperCase()+" "+num);
		System.out.println("2 - Quedan " + personasPlaya + " soldados en la playa");
	}

	/**
	 * El metodo desembarcar() manda dos mensajes una que esta desembarcando y otra
	 * cuantos han embarcado en total.
	 * 
	 * @param nombre     Recibe el nombre de vehículo de rescate
	 * @param rescatadas Recibe cuantas personas estan en el vehículo de rescate
	 * @param cont       Se utilizara para contar las personas rescatadas de este hilo
	 */

	public void desembarcar(String nombre, int rescatadas, int num, Contador cont) {
		System.out.println("3 - Han desembarcado en los barcos de alta mar " + rescatadas + " soldados desde "
				+ nombre.toUpperCase()+" "+num);
		System.out.println("4 - Han embarcado " + personasRescatadas + " soldados en total");
	}

	/**
	 * El metodo semaforo()
	 * 
	 * @throws InterruptedException Interrumpe cuando la clase ContadorDias ha
	 *                              terminado.
	 */
	public void semaforo(int num) throws InterruptedException {
		semaforo.acquire();
		Thread.sleep(num);
		
		semaforo.release();
	}

	/**
	 * El metodo getPersonasPlaya() de vuelve un return
	 * 
	 * @return personasPlaya De vuelve cuantas personas estan en la playa
	 */
	public int getPersonasPlaya() {
		return personasPlaya;
	}

	/**
	 * El metodo getPersonasRescatadas() de vuelve un return
	 * 
	 * @return personasRescatadas De vuelve cuantas personas ha sido rescatadas
	 */
	public int getPersonasRescatadas() {
		return personasRescatadas;
	}

}
