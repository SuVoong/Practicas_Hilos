package clases_reparto_domicilio;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
public class Mesa {
	private int[] posicion = new int[5];
	private boolean fin = false;
//	private boolean vacio = true;

	public synchronized void cocinar_Hamburguesas(int tipo, Contador cont) throws InterruptedException {
		for (int i = 0; i < posicion.length; i++) {
			if (posicion[i] == 0) {
				posicion[i] = tipo;
				cont.masCont();
				System.out.println("Preparando una hamburguesa...");
				notifyAll();
				return;
			}
		}
		
		wait();
//		System.out.println("¿¿ \t ------SE durmio Humburguesa");
	}

	public synchronized void cocinar_Pizzas(int tipo, Contador cont) throws InterruptedException {
		for (int i = 0; i < posicion.length; i++) {
			if (posicion[i] == 0) {
				posicion[i] = tipo;
				cont.masCont();
				System.out.println("Preparando una pizza...");
				notifyAll();
				return;
			}
		}
		wait();
//		System.out.println("¿¿ \t ------SE durmio Pizza");
	}

//	El notifyAll() o notify() funciona como quiere, me duele la cabeza de pensar

	public synchronized void repartidor(int tipo, String nombre, Contador cont) throws InterruptedException {
		
		if (this.posicion[0] == 0 && this.posicion[1] == 0 && this.posicion[2] == 0 && this.posicion[3] == 0
				&& this.posicion[4] == 0) {
			wait();
		}
		for (int i = 0; i < posicion.length; i++) {
			if (posicion[i] == tipo) {
				posicion[i] = 0;
				if (tipo == 1) {

					System.out.println("El repartidor " + nombre + " recogio la hambuerguesa");
				} else {

					System.out.println("El repartidor " + nombre + " recogio la pizza");
				}
				System.out.println("Mesa queda [" + this.posicion[0] + ", " + this.posicion[1] + ", " + this.posicion[2]
						+ ", " + this.posicion[3] + ", " + this.posicion[4] + "]");
				notifyAll();
				cont.masCont();
				return;
			}

		}
		wait();
	}

	public boolean getFin() {
		return fin;
	}
}
