package hilos_reparto_domicilio;

import clases_reparto_domicilio.Contador;
import clases_reparto_domicilio.Mesa;

/**
 * 
 * @author SuShan Voong Sun
 * @since 30/10/2023
 *
 */
public class Repartidor extends Thread {
	private Mesa mesa;
	private int tipo;
	private String nombre;
	private Contador cont;
	private boolean fin;
	public Repartidor(Mesa mesa, int tipo, String nombre) {
		Contador cont = new Contador();
		this.cont = cont;
		this.nombre = nombre;
		this.mesa = mesa;
		this.tipo = tipo;
		this.fin = false;
	}

	// if(!mesa.getVacio()) no funciona

	public void run() {
		while (!fin) {
			try {
				mesa.repartidor(tipo, nombre, cont);
				int num = (int) (Math.random() * 600);
				Thread.sleep(num);
			} catch (InterruptedException e) {
				fin = true;
				if (tipo == 1) {
					System.out.println("\t- El repartidor " + nombre + " ha repartido " + cont.getCont() + " hamburguesas. -");
				} else {
					System.out.println("\t- El repartidor " + nombre + " ha repartido " + cont.getCont() + " pizzas. -");
				}
			}
		}

//		if (tipo == 1) {
//			System.out.println("\t- El repartidor " + nombre + " ha repartido " + cont.getCont() + " hamburguesas. -");
//		} else {
//			System.out.println("\t- El repartidor " + nombre + " ha repartido " + cont.getCont() + " pizzas. -");
//		}	

	}
}
