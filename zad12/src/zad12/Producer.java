package zad12;
import java.util.Random;

public class Producer extends Thread{
	private Random generator = new Random();
	private Buffer b;
	
	public Producer(Buffer b){
		this.b = b;
	}
	
	public void run(){
		while(true){
			if(!b.isFull){
				int p = generator.nextInt(255);
				b.put(p);
				System.out.println("Dodaje do bufora: " + p);
				System.out.println(b);
			}
			int sleepTime = generator.nextInt(2000);
			try {
				Thread.sleep(sleepTime);
			}catch(InterruptedException exc){
				return;
			}
		}
	}
}
