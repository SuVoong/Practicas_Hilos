package main;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
import java.util.concurrent.Semaphore;

public class Isla {
	private int cantidadPersona;
	private boolean fin;
	private boolean empezar;
	private int rescatados;
	

	public Isla(int cantidadPersona) {
		this.cantidadPersona = cantidadPersona;
		this.fin = false;
		this.rescatados = 0;
		this.empezar = false;
	}

	public void resacate(int tipo, int capacidad, Contador cont) {
		if (cantidadPersona != 0) {
			System.out.println("Quedan " + cantidadPersona + " náufragos");
			if (cantidadPersona > capacidad) {
				cantidadPersona = cantidadPersona-capacidad;
				System.out.println("La balsa actual es Balsa " + tipo + " y rescatamos a " + capacidad + " personas, quedan: "+cantidadPersona);
				cont.masCont(capacidad);
				return;
			} else if (cantidadPersona < capacidad && cantidadPersona > 0) {
				cont.masCont(cantidadPersona);
				System.out.println("La balsa actual es Balsa " + tipo + " y rescatamos a " + cantidadPersona + " personas, quedan: "+cantidadPersona);
				cantidadPersona = 0;
				return;
			}
		} else {
			System.out.println("La balsa actual es Balsa " + tipo + " y rescatamos a " + cantidadPersona + " personas, quedan: "+cantidadPersona);
			System.out.println("No quedan supervivientes");
			fin = true;
		} 
	} 

	Semaphore semaforo = new Semaphore(2);
	
	/* 
	 * Si no pones empezar en el mensaje de cantidadPersonas se sincroniza, eso creo yo
	 */
	
	public void semaforo(int tipo, int capacidad, Contador cont) {
		try {	
			if (empezar) {
//				System.out.println("Quedan " + cantidadPersona + " náufragos ");
				Thread.sleep(50);
				resacate(tipo, capacidad, cont);
			}
			
			semaforo.acquire();
			empezar = true;
//			resacate(tipo, capacidad);			
			Thread.sleep(3 * 1000);
			semaforo.release();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isFin() {
		return fin;
	}

	public int getRescatados() {
		return rescatados;
	}

}
