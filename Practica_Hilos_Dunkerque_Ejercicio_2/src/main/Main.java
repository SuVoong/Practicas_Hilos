package main;
/**
 * @author SuShan Voong Sun
 */
import clases.Playa;
import hilos.ContadorDias;
import hilos.TipoBarco;

public class Main {
	/**
	 * En el main arrancamos los hilos: lancha, bote y contD,
	 * cuando contD termine se interrumpe lancha y bote.
	 * Despues se muestra los resultado de la Operación Dinamo 1
	 */
	public static void main(String [] args) throws InterruptedException {
		Playa isla = new Playa(400000);
		int barco = 5;
		Thread[] hiloLancha = new Thread[barco];
		Thread[] hiloBote = new Thread[barco];
		
		for (int i = 0; i < barco; i++) {
			hiloLancha[i] = new TipoBarco("lanchas", isla, (i+1),Thread.MIN_PRIORITY);
		}
		
		for (int i = 0; i < barco; i++) {
			hiloBote[i] = new TipoBarco("bote salvavidas", isla, (i+1));
		}
		
		ContadorDias contD = new ContadorDias(6, Thread.MAX_PRIORITY);
		
		for (int i = 0; i < barco; i++) {
			hiloBote[i].start();
			hiloLancha[i].start();
		}
		contD.start();
		
		while(contD.isAlive()) {
			Thread.sleep(1);
		}
		for (int i = 0; i < barco; i++) {
			hiloLancha[i].interrupt();
			hiloBote[i].interrupt();
		}
		
//		Pongo Thread.sleep(100); para que salga el último
		
		Thread.sleep(100);
		System.out.println("\nOperación Dinamo finalizada 2.");
		System.out.println("Se han salvado "+isla.getPersonasRescatadas()+" soldados en total");
		System.out.println("Se han quedado en la playa "+isla.getPersonasPlaya()+" soldados que deberan rendirse al ejercito aleman");
	
	
	}
}
