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

	public synchronized void cocinar_Hamburguesas(int tipo, Contador cont) {
		for (int i = 0; i < posicion.length; i++) {
			if (posicion[i] == 0) {
				posicion[i] = tipo;
				cont.masCont();
				System.out.println("Preparando una hamburguesa...");
				try {
					int num = (int) (Math.random() * 200);
					Thread.sleep(num);
				} catch (InterruptedException e) {
					notifyAll();
					fin = true;
				}
				
//				vacio = false;
//				System.out.println("Hamburgesa lista para entregar en poción "+ i);
//				System.out.println("["+this.posicion[0]+", "+this.posicion[1]+", "+this.posicion[2]+", "+this.posicion[3]+", "+this.posicion[4]+"]");
				notifyAll();
				return;
			}
		}
		esperar();
//		System.out.println("¿¿ \t ------SE durmio Humburguesa");
	}

	public synchronized void cocinar_Pizzas(int tipo, Contador cont) {
		for (int i = 0; i < posicion.length; i++) {
			if (posicion[i] == 0) {
				posicion[i] = tipo;
				cont.masCont();
				System.out.println("Preparando una pizza...");
				try {
					int num = (int) (Math.random() * 300);
					Thread.sleep(num);
				} catch (InterruptedException e) {
					notifyAll();
					fin = true;
				}
//				vacio = false;
//				System.out.println("Pizza lista para entregar en poción "+ i);
//				System.out.println("["+this.posicion[0]+", "+this.posicion[1]+", "+this.posicion[2]+", "+this.posicion[3]+", "+this.posicion[4]+"]");
				notifyAll();
				return;
			}
		}
		esperar();
//		System.out.println("¿¿ \t ------SE durmio Pizza");
	}

//	El notifyAll() o notify() funciona como quiere, me duele la cabeza de pensar
	
	public synchronized void repartidor(int tipo, String nombre, Contador cont) {
		if(this.posicion[0] == 0 && this.posicion[1] == 0 && this.posicion[2] == 0 && this.posicion[3] == 0 && this.posicion[4] == 0) {
			esperar();
		}
		for (int i = 0; i < posicion.length; i++) {
			if(posicion[i] == tipo) {
//				System.out.println("Mesa antes ["+this.posicion[0]+", "+this.posicion[1]+", "+this.posicion[2]+", "+this.posicion[3]+", "+this.posicion[4]+"]");
				posicion[i] = 0;
				if(tipo == 1) {
//					 de la posición "+ i
					System.out.println("El repartidor "+nombre+" recogio la hambuerguesa");
				} else {
//					 de la posición "+posicion[i]
					System.out.println("El repartidor "+nombre+" recogio la pizza");
				}
				System.out.println("Mesa queda ["+this.posicion[0]+", "+this.posicion[1]+", "+this.posicion[2]+", "+this.posicion[3]+", "+this.posicion[4]+"]");
				
				notifyAll();
				cont.masCont();
				int num = (int) (Math.random() * 600);
				try {
					Thread.sleep(num);
				} catch (InterruptedException e) {
					
					fin = true;
				}
//				vacio = false;
				
				return;
			}
			
		}
		esperar();
	}

	public void esperar() {
		try {
			wait();
		} catch (Exception e) {
			fin = true;
		}
	}

	public boolean getFin() {
		return fin;
	}
	
//	No funciona
//	
//	public boolean getVacio() {
//		return vacio;
//	}
}
