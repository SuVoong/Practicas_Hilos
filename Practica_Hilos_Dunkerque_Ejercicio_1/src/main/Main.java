package main;
import clases.BarcoBase;
/**
 * @author SuShan Voong Sun
 */
import clases.Isla;
import hilos.ContadorDias;
import hilos.TipoBarco;

public class Main {
	/**
	 * En el main arrancamos los hilos: lancha, bote y contD,
	 * cuando contD termine se interrumpe lancha y bote.
	 * Despues se muestra los resultado de la Operación Dinamo 1
	 */
	public static void main(String [] args) throws InterruptedException {
		Isla isla = new Isla(400000);
		BarcoBase barcoBase = new BarcoBase();
		TipoBarco lancha = new TipoBarco("lanchas", isla, barcoBase);
		TipoBarco bote = new TipoBarco("bote salvavidas", isla, barcoBase);
		ContadorDias contD = new ContadorDias(6, Thread.MAX_PRIORITY);
		
		lancha.start();
		contD.start();
		bote.start();
		
		while(contD.isAlive()) {
			Thread.sleep(1);
		}
		
		lancha.interrupt();
		bote.interrupt();
		
//		Pongo Thread.sleep(100); para que salga el último
		
		Thread.sleep(100);
		System.out.println("\nOperación Dinamo finalizada 1.");
		System.out.println("Se han salvado "+isla.getPersonasRescatadas()+" soldados en total");
		System.out.println("Se han quedado en la playa "+isla.getPersonasIsla()+" soldados que deberan rendirse al ejercito aleman");
	
	
	}
}
