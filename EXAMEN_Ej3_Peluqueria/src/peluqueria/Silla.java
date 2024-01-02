package peluqueria;
//SuShan Voong Sun
public class Silla {
	private int[] sillas;
	private boolean fin;
	private int numMujer;
	private int numHombre;

	public Silla() {
		this.sillas = new int[4];
		this.fin = false;
		this.numMujer = 0;
		this.numHombre = 0;

	}

	public String genero(int tipo) {
		String genero = "";
		if (tipo == 1) {
			genero = "hombre";
		} else {
			genero = "mujer";
		}
		return genero;
	}

	public synchronized void sentarSilla(int tipo, int numHilo) throws InterruptedException {
		String genero = genero(tipo);
		for (int i = 0; i < sillas.length; i++) {
			if (sillas[i] == 0) {
				sillas[i] = tipo;
				System.out.println("Se ha sentado un/a " + genero + " en la posicion " + i);
				notifyAll();
				System.out.println("[" + sillas[0] + " " + sillas[1] + " " + sillas[2] + " " + sillas[3] + "]");
				return;
			}
		}
		wait();
	}

	public void atenderSilla(int tipo, int numHilo) throws InterruptedException {
		for (int i = 0; i < sillas.length; i++) {
			if (sillas[i] == tipo) {
				sillas[i] = 0;

					if (numHilo == 3) {
						System.out.println("El peluquero ambos sexos va acortar a un/a " + genero(tipo));
						if (genero(tipo).equalsIgnoreCase("hombre")) {
							numHombre++;
						} else {
							numMujer++;
						}

					} else if (numHilo == 1) {
						System.out.println("El peluquero hombre va acortar a un/a " + genero(tipo));
						numHombre++;

					} else if (numHilo == 2) {
						System.out.println("El peluquero mujer va acortar a un/a " + genero(tipo));
						numMujer++;

					}

			}
		}

	}
	
	public void mostrarFinal() {
		System.out.println("Quedan en las sillas de la peluqueria[" + sillas[0] + " " + sillas[1] + " " + sillas[2] + " " + sillas[3] + "]");
		System.out.println("Clientes que han entrado en total: "+ (numHombre+numMujer));
		System.out.println("Recogidos por tipos: ["+numHombre+", "+numMujer+"]");
	}

	public boolean getFin() {
		return fin;
	}
}
