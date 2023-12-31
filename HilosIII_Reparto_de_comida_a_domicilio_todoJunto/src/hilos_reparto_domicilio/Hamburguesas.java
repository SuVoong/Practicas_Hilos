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
	public Hamburguesas(Mesa mesa) {
		Contador cont = new Contador();
		this.cont = cont;
		this.mesa = mesa;
		tipo = 1;
	}
	
// if(!mesa.getVacio()) no funciona
	
	public void run() {
		while(!mesa.getFin()) {
			mesa.cocinar_Hamburguesas(tipo, cont);
//			if(!mesa.getVacio()) {
//				cont.masCont();
//			}
			System.out.println("Hamburgesa lista para entregar");
//			System.out.println("Hamburguesas: "+cont.getCont());
		}
//		try {
//			Thread.sleep(1000);
			System.out.println("\t- Hambuerguesas entregadas en total: "+cont.getCont()+" -");
//		} catch (InterruptedException e) {
//			System.out.println("Hambuerguesas entregadas en total: "+cont.getCont());
//		}
	}
	
	
}
