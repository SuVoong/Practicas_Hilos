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
public class Pizzas extends Thread{
	private Mesa mesa;
	private int tipo;
	private Contador cont;
	private boolean fin;
	public Pizzas(Mesa mesa) {
		Contador cont = new Contador();
		this.cont = cont;
		this.mesa = mesa;
		this.tipo = 2;
		this.fin = false;
	}
	
	// if(!mesa.getVacio()) no funciona
	
	public void run() {
		while(!fin) {
			try {
				mesa.cocinar_Pizzas(tipo, cont);
				int num = (int) (Math.random() * 300);
				Thread.sleep(num);
			} catch (InterruptedException e) {
				System.out.println("\t- Pizzas entregadas en total: "+cont.getCont()+" -");
			fin = true;
			}
			System.out.println("Pizza lista para entregar");
		}
//			System.out.println("\t- Pizzas entregadas en total: "+cont.getCont()+" -");

		
	}
}
