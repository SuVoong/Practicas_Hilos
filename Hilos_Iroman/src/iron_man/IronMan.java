package iron_man;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
public class IronMan extends Thread {

	private int correrV;
	private int biciV;
	private int nadarV;
	private String nombre;

	public IronMan(String nombre, int correrV, int biciV, int nadarV) {
		this.nombre = nombre;
		this.correrV = correrV;
		this.biciV = biciV;
		this.nadarV = nadarV;

	}

	public void metodoCorrer() {
		int marathon = 42;
		int total = marathon / correrV;
		System.out.println(nombre+" comienza la marathon.");
		try {
			Thread.sleep(total * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(nombre+" ha acabado la marathon.");
	}

	public void metodoBici() {
		int bici = 180;
		int total = bici / biciV;
		System.out.println(nombre+" comienza la pruba en bici.");
		try {
			Thread.sleep(total * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(nombre+" ha acabado la pruba en bici.");
	}

	public void metodoNadar() {
		int nadar = 4000;
		int total = nadar / nadarV;
		System.out.println(nombre+" comienza la pruba de natación.");
		try {
			Thread.sleep(total * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(nombre+" ha acabado la pruba de natación.");
	}
	
	
	public void run() {
		this.metodoBici();
		this.metodoCorrer();
		this.metodoNadar();
	}
}
