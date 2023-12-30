package par_impar;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */

public class Numeros implements Runnable {
	private  int[] num;
	private  int tiempo;

	public Numeros(int[] num, int tiempo) {
		super();
		this.num = num;
		this.tiempo = tiempo;
	}
	public void escribir() {	
		try {
			for (int i = 0; i < num.length; i++) {
				System.out.println(num[i]);
				Thread.sleep(tiempo * 1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.escribir();

	}

}
