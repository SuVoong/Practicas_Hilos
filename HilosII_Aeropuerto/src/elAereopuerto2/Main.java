package elAereopuerto2;

public class Main {
	public static void main(String [] args) {
		int cantidadDeAeroplano = 20;
		Aereopuerto2 aero = new Aereopuerto2(cantidadDeAeroplano);
		for (int i = 0; i < 30; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			Aereoplano2 cosa = new Aereoplano2(aero);
//			cosa.start();
		}
		
	}
}
