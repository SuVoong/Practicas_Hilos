package hilos;
/**
 * @author SuShan Voong Sun
 */
public class ContadorDias extends Thread{
	private int dias;
	
	/**
	 * Este es el constructor ContadorDias()
	 * @param dias  Recibe cuantos dias durará el hilo
	 * @param prioridad  Le da la máxima prioridad, comenzaando antes que otros hilos
	 */
	
	public ContadorDias(int dias, int prioridad) {
		this.dias = dias;
		this.setPriority(prioridad);
	}
	
	/**
	 * Este metodo run() arranca el hilo, teniendo un Thread.sleep que durará 24 segundo cada vuelta (dia).
	 * Cuando pase de dia mandara un mensaje.
	 */
	public void run() {
		for (int i = 1; i < (this.dias + 1); i++) {
			try {
				Thread.sleep(24 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("5 - HAN PASADO "+i+" DIAS DE COMBATE.");
		}
	}
}
