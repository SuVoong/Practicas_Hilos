package artificiero;

public class Main {
	public static void main(String[] agrs) throws InterruptedException {
		Artificiero_Bomba artificiero = new Artificiero_Bomba("artificiero");
		Artificiero_Bomba bomba = new Artificiero_Bomba("bomba");
		artificiero.start();
		bomba.start();
		
//		No sigue el programa hasta que uno de los dos termine
		while (bomba.isAlive() && artificiero.isAlive()) {
			Thread.sleep(100);
		}
		
//		El artificiero muerre
		if (!bomba.isAlive() && artificiero.isAlive()) {
			artificiero.interrupt();
		}
		
//		El artificiero desactiva la bomba
		if (bomba.isAlive() && !artificiero.isAlive()) {
			bomba.interrupt();
		}
	}
}
