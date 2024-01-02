package peluqueria;
//SuShan Voong Sun
public class Main {
	public static void main(String [] args) {
//		System.out.println("\t Tipos");
//		System.out.println("------------------------------");
//		System.out.println("\tHombres = 1");
//		System.out.println("\tMujeres = 2");
//		System.out.println("------------------------------ \n");
		Silla silla = new Silla();
		Peluquero hombre = new Peluquero(1, 1, silla);
		Peluquero mujer = new Peluquero(2, 2, silla);
		Peluquero ambos = new Peluquero(3, 0, silla);
		hombre.start();
		mujer.start();
		ambos.start();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
//			System.out.println(i);
		}
		
		hombre.interrupt();
		mujer.interrupt();
		ambos.interrupt();
		
		try {
			Thread.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		silla.mostrarFinal();
	}
}
