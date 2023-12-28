package clases;

public class BarcoBase {
	
	private int personasRescatadas;

	/**
	 * Este es el constructor BarcoBase()
	 * 
	 */

	public BarcoBase() {
		this.personasRescatadas = 0;
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
}
