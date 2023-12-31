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
	
	public Pizzas(Mesa mesa) {
		Contador cont = new Contador();
		this.cont = cont;
		this.mesa = mesa;
		tipo = 2;
	}
	
	// if(!mesa.getVacio()) no funciona
	
	public void run() {
		while(!mesa.getFin()) {
			mesa.cocinar_Pizzas(tipo, cont);
//			if(!mesa.getVacio()) {
//				cont.masCont();
//			}
			System.out.println("Pizza lista para entregar");
//			System.out.println("Pizzas: "+cont.getCont());
		}
//		try {
//			Thread.sleep(1000);
			System.out.println("\t- Pizzas entregadas en total: "+cont.getCont()+" -");
//		} catch (InterruptedException e) {
//			System.out.println("Pizzas entregadas en total: "+cont.getCont());
//		}
		
	}
}
