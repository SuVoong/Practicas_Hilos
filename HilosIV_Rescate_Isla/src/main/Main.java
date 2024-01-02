package main;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
public class Main {
	public static void main(String [] args) {
		int cantidadPersona = 800 + ((int) (Math.random() * (1000 - 800)));
		Isla isla = new Isla(cantidadPersona);
		
		Barcas b1 = new Barcas(1, isla);
		Barcas b2 = new Barcas(2, isla);
		Barcas b3 = new Barcas(3, isla);
		
		b1.start();
		b2.start();
		b3.start();
		System.out.println("-------------------------");
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
