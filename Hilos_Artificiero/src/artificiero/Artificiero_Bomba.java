package artificiero;

public class Artificiero_Bomba extends Thread {
	String nombre;

	public Artificiero_Bomba(String nombre) {
		this.nombre = nombre;
	}
	
//	Método del artificiero, he añadido 500 más porque terminaba antes que el metodo bomba()
	public void artificiero() {
		System.out.println("EL artificiero comienza a desactivar la bomba");
		try {
			int num = (int) (9000 + (Math.random() * (10500 - 9000)));
			System.out.println(num);
			Thread.sleep(1 * num);
		} catch (InterruptedException e) {
			System.out.println("PUUUUUUUUMMMMMMMMMMMMMM!!!!");
			System.out.println("Ha muerto el artificiero.");
			return;
		}

	}

//	Método bomba, si artificiero termina, interrumpe el método bomba y no explota.
	public void bomba() {
		for (int i = 9; i >= 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				System.out.println("El artificiero ha desactivado la bomba");
				System.out.println("La bomba ha sido desactivada");
				return;
			}
		}
	}

	public void run() {
		if (nombre.equalsIgnoreCase("artificiero")) {
			this.artificiero();
		} else if (nombre.equalsIgnoreCase("bomba")) {
			this.bomba();
		}
	}

}
