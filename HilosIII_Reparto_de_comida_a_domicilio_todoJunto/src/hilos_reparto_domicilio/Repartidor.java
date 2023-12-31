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
public class Repartidor extends Thread{
	private Mesa mesa;
	private int tipo;
	private String nombre;
	private Contador cont;
	public Repartidor(Mesa mesa, int tipo, String nombre) {
		Contador cont = new Contador();
		this.cont = cont;
		this.nombre = nombre;
		this.mesa = mesa;
		this.tipo = tipo;
	}
	
	// if(!mesa.getVacio()) no funciona
	
	public void run() {
		while(!mesa.getFin()) {
			mesa.repartidor(tipo, nombre, cont);
//			if(!mesa.getVacio()) {
//				cont.masCont();
//			}
//			System.out.print(".");
//			System.out.println(nombre+": "+cont.getCont());
			
		}
//		try {
//			Thread.sleep(1000);
			if(tipo == 1) {
				System.out.println("\t- El repartidor "+nombre+" ha repartido "+cont.getCont()+" hamburguesas. -");
			} else {
				System.out.println("\t- El repartidor "+nombre+" ha repartido "+cont.getCont()+" pizzas. -");
			}
//		} catch (InterruptedException e) {
//			if(tipo == 1) {
//				System.out.println("El repartidor "+nombre+" ha repartido "+cont.getCont()+" hamburguesas.");
//			} else {
//				System.out.println("El repartidor "+nombre+" ha repartido "+cont.getCont()+" pizzas.");
//			}
//		}
		
	}
}
