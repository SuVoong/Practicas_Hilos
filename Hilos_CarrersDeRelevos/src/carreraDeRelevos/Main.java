package carreraDeRelevos;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
public class Main {
	public static void main(String[] agrs) {
//		Creo Array de con los nombre de los parcipantes de si pais
		String []nomEsp = {"Pepe", "Maria", "Juan", "Marta"};
		String []nomEEUU = {"John", "Kim", "Mike", "Sarah"};
		
		CorredoresInternacionales espania = new CorredoresInternacionales("España", nomEsp);
		CorredoresInternacionales eeuu = new CorredoresInternacionales("EEUU", nomEEUU);
		
		espania.start();
		eeuu.start();
	
	}
}
