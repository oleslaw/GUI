package zad12;
import java.util.Random;

public class Consumer extends Thread{
	private Random generator = new Random();
	private Buffer b;
	
	public Consumer(Buffer b){
		this.b = b;
		
	}
	
	public void run(){
		while(true){
			if(!b.isEmpty){
				System.out.println("Odejmuje z bufora: " + b.get());
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
