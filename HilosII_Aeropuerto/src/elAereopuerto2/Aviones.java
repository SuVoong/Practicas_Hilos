package elAereopuerto2;

public class Aviones extends Thread{
	private String nombre;
	private int turno;
	public Aviones(int turno) {
		super();
		this.nombre = "AVION";
		this.turno = turno;
	}
	public void avion() {
		try {
			System.out.println("Aeroplano ded tipo: "+nombre+" con número Thread-"+turno+" entra en la pista");
			Thread.sleep(3000);
			System.out.println("Aeroplano ded tipo: "+nombre+" con número Thread-"+turno+" entra en la pista");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.avion();
	}
	
}
