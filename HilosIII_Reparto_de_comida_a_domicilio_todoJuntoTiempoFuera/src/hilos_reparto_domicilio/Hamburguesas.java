package hilos_reparto_domicilio;

import clases_reparto_domicilio.Contador;
import clases_reparto_domicilio.Mesa;

/**
* 
* @author SuShan Voong Sun
* @since 30/10/2023
*
* clase RobotColocador
*/
public class Hamburguesas extends Thread{
	private int tipo;
	private Mesa mesa;
	private Contador cont;
	private boolean fin = false;
	public Hamburguesas(Mesa mesa) {
		Contador cont = new Contador();
		this.cont = cont;
		this.mesa = mesa;
		this.tipo = 1;
		this.fin = false;
	}
	
	public void run() {
		while(!fin) {
			try {
				mesa.cocinar_Hamburguesas(tipo, cont);
				int num = (int) (Math.random() * 200);
				Thread.sleep(num);
			} catch (InterruptedException e) {
				System.out.println("\t- Hambuerguesas entregadas en total: "+cont.getCont()+" -");
			fin = true;
			}
			System.out.println("Hamburgesa lista para entregar");

		}	
		//No es necesario ya que no continua
//			System.out.println("\t- Hambuerguesas entregadas en total: "+cont.getCont()+" -");

	}
	
	
}
