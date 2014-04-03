package zad12;

public class Test {

	public static void main(String[] args) {
		
		Buffer B = new Buffer();
		Producer P = new Producer(B);
		
		Consumer C = new Consumer(B);

		P.start();
		C.start();
		
		try{
			Thread.sleep(15000);
		}catch(InterruptedException exc){
			
		}
		
		P.interrupt();
		C.interrupt();
		
		

	}

}
