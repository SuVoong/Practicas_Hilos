package main;
/**
 * 
 * @author Su Shan Voong Sun
 *
 */
public class Contador {
	private int cont;
	public Contador() {
		this.cont = 0;
	}
	public int getCont() {
		return cont;
	}
	public void masCont(int num) {
		this.cont += num;
	}
	
}
