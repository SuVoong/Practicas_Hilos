package elAereopuerto2;

public class Aereopuerto2 {
	private int cantidadAeroplano;
	private int turno;
	private boolean elecion;
	
	public Aereopuerto2(int cantidadAeroplano) {
		this.cantidadAeroplano = cantidadAeroplano;
		turno = 1;
	}

	public int posicion() {
		return turno;
	}

	public boolean elecion() {
		return elecion;
	}

	
	public synchronized void selector() {
		int num = (int) (Math.random() * 2);
		if (cantidadAeroplano < turno) {
			return;
		}
//		System.out.println("Llega a pista el/la AVION con número Thread-"+posicion());
		try {
			if (num == 1) {
				try {
					String nombre1 = "AVIONETAS";
					System.out.println("Llega a pista el/la AVIONETA con número Thread-"+posicion());
					System.out.println("Aeroplano de tipo: " + nombre1 + " con número Thread-" + turno
							+ " entra en la pista de despegue...");
//					Thread.sleep(2000);
//					System.out.println("Aeroplano de tipo: " + nombre1 + " con número Thread-" + turno + " ha despegado.");
					
				} catch (Exception e) {
					// TODO: handle exception
				}

				turno++;
				elecion = true;
			} else if (num == 0) {
				try {
					String nombre = "AVION";
					System.out.println("Llega a pista el/la AVION con número Thread-"+posicion());
					System.out.println("Aeroplano ded tipo: " + nombre + " con número Thread-" + turno + " entra en la pista de despegue...");
					Thread.sleep(3000);
					System.out.println("Aeroplano ded tipo: " + nombre + " con número Thread-" + turno + " ha despegado.");
				} catch (Exception e) {
					// TODO: handle exception
				}

				turno++;
				elecion = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
