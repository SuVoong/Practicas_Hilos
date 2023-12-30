package cadenaDeMontaje;
/**
* 
* @author SuShan Voong Sun
* @since 30/10/2023
*
* clase RobotColocador
*/
public class RobotColocador extends Thread {
	private int tipo;
	private Cinta c;
	private int productos;

	public RobotColocador(Cinta c) {
		this.c = c;
		productos = 0;
	}

	public void ponerCinta() {
		this.tipo = (int) (1 + (Math.random() * 3));
		System.out.println("Produciondo tipo " + this.tipo);
		c.poner(tipo);
		productos++;

	}
	public int productos() {
		return productos;
	}
	
	public void run() {
		while (c.getFin() == false) {
			this.ponerCinta();
		}

	}
}
