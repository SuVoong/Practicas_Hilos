package par_impar;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */

public class Par_Impar{
	public static void main(String [] args) {
		int [] arry1 = {1, 3, 5, 7, 9};
		int [] arry2 = {2, 4, 6, 8, 10};
		Numeros par = new Numeros(arry1, 1);
		Numeros impar = new Numeros(arry2, 2);
		
		new Thread(par).start();
		
		new Thread(impar).start();
	}
}
