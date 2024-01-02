package peluqueria;
//SuShan Voong Sun
public class Peluquero extends Thread {
	private int tipo;
	private int numHilo;
	private Silla silla;
	private boolean fin;

	public Peluquero(int numHilo, int tipo, Silla silla) {
		this.numHilo = numHilo;
		this.tipo = tipo;
		this.fin = false;
		this.silla = silla;

	}
	
	public int tipos() {
		int num = (int) (1 + (Math.random() * (3 - 1)));
		return num;
	}
	
	public void run() {
		if (numHilo == 3) {
			System.out.println("El hilo Thread-"+numHilo+" corta el pelo a cliente ambos sexos");

		} else if (numHilo == 1) {
			System.out.println("El hilo Thread-"+numHilo+" corta el pelo a cliente hombre");

		} else if (numHilo == 2) {
			System.out.println("El hilo Thread-"+numHilo+" corta el pelo a cliente mujer");

		}
		while (!fin) {
			try {
				if(tipo == 0) {
					silla.sentarSilla(tipos(), numHilo);
				} else {
					silla.sentarSilla(tipo, numHilo);
				}
				int num = (int) (Math.random() * 500);
				Thread.sleep(num);
				silla.atenderSilla(tipo, numHilo);
			} catch (InterruptedException e) {
				fin = true;
			}
		}
	}
}
