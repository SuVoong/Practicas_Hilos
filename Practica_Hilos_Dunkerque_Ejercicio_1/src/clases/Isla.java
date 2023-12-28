package clases;

/**
 * @author SuShan Voong Sun
 */

public class Isla {

	private int personasRescatadas;
	private int personasIsla;

	/**
	 * Este es el constructor Isla()
	 * 
	 * @param personasIsla Recibimos cuantas personas hay en la Isla
	 */

	public Isla(int personasIsla) {
		this.personasIsla = personasIsla;
		this.personasRescatadas = 0;
	}

	/**
	 * El metodo rescatar(), en el metodo resta cuantas personas estan en la playa
	 * en personasPlaya, y suma cuantas personas han rescatado en
	 * personasRescatadas.
	 * 
	 * @param nombre    Recibe el nombre de vehículo de rescate
	 * @param capacidad Recibe cuantas personas se embarcan en el vehículo de
	 *                  rescate
	 */
	public void rescatar(String nombre, int capacidad) {
		personasIsla -= capacidad;
		personasRescatadas += capacidad;
		System.out.println("1 - Han embarcado " + capacidad + " soldados de la playa en " + nombre.toUpperCase());
		System.out.println("2 - Quedan " + personasIsla + " soldados en la playa");
	}
	
	/**
	 * El metodo desembarcar() manda dos mensajes una que esta desembarcando y otra
	 * cuantos han embarcado en total.
	 * 
	 * @param nombre     Recibe el nombre de vehículo de rescate
	 * @param rescatadas Recibe cuantas personas estan en el vehículo de rescate
	 */

	public void desembarcar(String nombre, int rescatadas) {
		System.out.println("3 - Han desembarcado en los barcos de alta mar " + rescatadas + " soldados desde "
				+ nombre.toUpperCase());
		System.out.println("4 - Han embarcado " + personasRescatadas + " soldados en total");
	}

	/**
	 * El metodo synchronized trayecto() recibe el nombre y rescatadas.
	 * 
	 * @throws InterruptedException Interrumpe cuando la clase ContadorDias ha
	 *                              terminado.
	 */
	public synchronized void trayecto() throws InterruptedException {
		Thread.sleep(500);
	}

	/**
	 * El metodo getPersonasIsla() de vuelve un return
	 * 
	 * @return personasPlaya De vuelve cuantas personas estan en la playa
	 */
	public int getPersonasIsla() {
		return personasIsla;
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
