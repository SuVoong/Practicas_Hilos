package cadenaDeMontaje;
/**
* 
* @author SuShan Voong Sun
* @since 30/10/2023
*
* clase RobotEmpaquetador 
*/

public class RobotEmpaquetador extends Thread {
	private Cinta c;
	private int tipo;
	private int productos;

	public RobotEmpaquetador(Cinta c, int tipo) {
		this.c = c;
		this.tipo = tipo;
	}
	
	public int productos() {
		return productos;
	}

	public void recogerCinta() {
		for (int array : c.getPosicion()) {
			if (array == tipo) {
				c.empacar(tipo);
				System.out.println("Recogido producto " + this.tipo);
				productos++;
				return;
			}
		}

	}

	public void run() {
		while (c.getFin() == false) {
			this.recogerCinta();
		}
	}
}
