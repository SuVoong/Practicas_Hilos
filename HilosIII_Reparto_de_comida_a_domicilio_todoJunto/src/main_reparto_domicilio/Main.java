package main_reparto_domicilio;

import clases_reparto_domicilio.Mesa;
import hilos_reparto_domicilio.Hamburguesas;
import hilos_reparto_domicilio.Pizzas;
import hilos_reparto_domicilio.Repartidor;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
public class Main {
	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		System.out.println("\t Tipos");
		System.out.println("------------------------------");
		System.out.println("\tHamburguesas = 1");
		System.out.println("\tPizzas = 2");
		System.out.println("------------------------------ \n");
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Repartidor repartidor_pizzas1 = new Repartidor(mesa, 2, "Mario");
		Repartidor repartidor_pizzas2 = new Repartidor(mesa, 2, "Luigi");
		Repartidor repartidor_hambur1 = new Repartidor(mesa, 1, "Don Cangrejo");
		Repartidor repartidor_hambur2 = new Repartidor(mesa, 1, "Bob");

		Pizzas cocinero_pizzas = new Pizzas(mesa);

		Hamburguesas cocinero_hambur = new Hamburguesas(mesa);

		repartidor_pizzas1.start();
		repartidor_pizzas2.start();
		repartidor_hambur1.start();
		repartidor_hambur2.start();

		cocinero_pizzas.start();

		cocinero_hambur.start();

		for (int i = 0; i < 10; i++) {
//			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		cocinero_pizzas.interrupt();
		cocinero_hambur.interrupt();
		
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		repartidor_pizzas1.interrupt();
		repartidor_pizzas2.interrupt();
		repartidor_hambur1.interrupt();
		repartidor_hambur2.interrupt();

		
//		try {
//			Thread.sleep(200);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("\n\t Resultados");
//		System.out.println("-------------------------------- \n");
		

		
	}
}
