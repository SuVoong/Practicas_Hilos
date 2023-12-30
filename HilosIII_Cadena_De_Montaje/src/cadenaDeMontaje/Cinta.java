package cadenaDeMontaje;

/**
 * 
 * @author SuShan Voong Sun
 * @since 30/10/2023
 *
 *        clase Cinta
 */

public class Cinta {
	private int[] posicion = new int[3];
	private boolean fin = false;
	private boolean vacio = true;

	public void esperar() {
		try {
			wait();
		} catch (InterruptedException e) {
			fin = true;
		}
	}

	public synchronized void poner(int producto) {
		for (int i = 0; i < posicion.length; i++) {
			if (posicion[i] == 0) {
				posicion[i] = producto;
				System.out.println("Coloco un producto " + producto + " en la posicion " + i);
				System.out.println("[" + this.posicion[0] + ", " + this.posicion[1] + ", " + this.posicion[2] + "]");
				notifyAll();
				vacio = false;
				try {
					int num = (int) (Math.random() * 250);
					Thread.sleep(num);
				} catch (InterruptedException e) {
					fin = true;
				}
				return;
			}
		}
		esperar();

	}
	// else if(i == 3) peta y se produce un error.
	// posicion[0] == 0 && posicion[1] == 0 && posicion[2] == 0   ????

	public synchronized void empacar(int tipo) {
		if (posicion[0] == 0 && posicion[1] == 0 && posicion[2] == 0) {
			esperar();
		}
		for (int i = 0; i < posicion.length; i++) {
			if (posicion[i] == tipo) {
				posicion[i] = 0;
				notify();
				try {
					int num = (int) (Math.random() * 500);
					Thread.sleep(num);
				} catch (InterruptedException e) {
					fin = true;
				}
				return;
			}
		}
	}

	public int[] getPosicion() {
		return posicion;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public boolean getFin() {
		return fin;
	}

	public void restos() {
		System.out.println(
				"Quedan en la cinta: [" + this.posicion[0] + ", " + this.posicion[1] + ", " + this.posicion[2] + "]");
	}

}
