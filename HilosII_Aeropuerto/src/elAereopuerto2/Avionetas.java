package elAereopuerto2;

public class Avionetas extends Thread{
	private String nombre;
	private int turno;
	public Avionetas(int turno) {
		super();
		this.nombre = "AVIONETAS";
		this.turno = turno;
	}
	public void avioneta() {
		try {
			System.out.println("Aeroplano de tipo: "+nombre+" con número Thread-"+turno+" entra en la pista de despegue...");
			Thread.sleep(1500);
			System.out.println("Aeroplano de tipo: "+nombre+" con número Thread-"+turno+" ha despegado.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		avioneta();
	}
}
