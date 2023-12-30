package cadenaDeMontaje;

/**
 * 
 * @author SuShan Voong Sun
 * @since 30/10/2023
 *
 *        clase Main
 */

public class Main {
	public static void main(String[] args) {
		Cinta c = new Cinta();
		RobotEmpaquetador rEmpaqueta_1 = new RobotEmpaquetador(c, 1);
		RobotEmpaquetador rEmpaqueta_2 = new RobotEmpaquetador(c, 2);
		RobotEmpaquetador rEmpaqueta_3 = new RobotEmpaquetador(c, 3);

		RobotColocador rEntregador = new RobotColocador(c);

		rEmpaqueta_1.start();
		rEmpaqueta_2.start();
		rEmpaqueta_3.start();
		
		rEntregador.start();

		for (int i = 10; i > 0; i--) {
			// System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		rEmpaqueta_1.interrupt();
		rEmpaqueta_2.interrupt();
		rEmpaqueta_3.interrupt();
		rEntregador.interrupt();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		c.restos();
		System.out.println("Recogidos por tipo:[" + rEmpaqueta_1.productos() + ", " + rEmpaqueta_2.productos() + ", "
				+ rEmpaqueta_3.productos() + "] ");
		System.out.println("Puestos en total: " + rEntregador.productos());
		// System.out.println("Se acabo");

	}

}
