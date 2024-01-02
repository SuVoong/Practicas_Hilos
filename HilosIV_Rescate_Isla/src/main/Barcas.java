package main;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
public class Barcas extends Thread {
	private int tipo;
	private int capacidad;
	private Isla isla;
	private Contador cont;

	public Barcas(int tipo, Isla isla) {
		this.cont = new Contador();
		this.isla = isla;
		this.tipo = tipo;
		tipos(tipo);
	}

	public void tipos(int tipo) {
		if (tipo == 1) {
			int num = 20 + ((int) (Math.random() * (40 - 20)));
			this.capacidad = num;
		} else if (tipo == 2) {
			int num = 30 + ((int) (Math.random() * (50 - 30)));
			this.capacidad = num;
		} else if (tipo == 3) {
			int num = 40 + ((int) (Math.random() * (60 - 40)));
			this.capacidad = num;
		}
	}

	/* 
	 *  Nada me he estresano pero ahora de chill.
	 *  AHHHHHHHHHHH, ME DUELE LA VIDA, LO "CONSEGUI", no se si ya otra manera.
	 */
	
	public void run() {
		System.out.println("La balsa " + tipo + " tiene " + capacidad + " plazas");
		while (!isla.isFin()) {
			isla.semaforo(tipo, capacidad, cont);
		}
		System.out.println("Ya no quedan náufragos y la Balsa "+tipo+" está volviendo a su puesto. Ha rescatado "+cont.getCont()+" náufragos en total");

	}

}
