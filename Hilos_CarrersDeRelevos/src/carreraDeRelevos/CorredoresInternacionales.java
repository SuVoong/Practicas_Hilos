package carreraDeRelevos;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
public class CorredoresInternacionales extends Thread {

	String[] nombre;
	String pais;

	public CorredoresInternacionales(String pais, String[] nombre) {
		this.pais = pais;
		this.nombre = nombre;
	}
	
//	Método velocidad cada participante tiene una velocidad aleatoria, mostrandolo cuanto tiempo lleva en decimales.
	public void velocidad() {
		for (String nom : nombre) {
			double total = 0;
			System.out.println(pais + ":" + nom + " comienza su relevo");
			for (int i = 0; i < 10; i++) {
				int num = (int) (950 + (Math.random() * (1050 - 950)));
				total += (double) 1000 / num;
				try {
					Thread.sleep(1 * num);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			System.out.println(pais + ":" + nom + " ha acabado su relevo - Ha tardado: "
					+ String.format("%.2f", total) + " segundos");

		}
		System.out.println("FIN DE PROGRAMA - "+pais);
	}

	@Override
	public void run() {
		this.velocidad();

	}
}
