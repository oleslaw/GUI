
public class Juror extends Thread {
	private int czas;
	
	public Juror(int czas){
		this.czas = czas;
	}
	
	public void run(){
		int time = 0;
	    for (int i = 0; i < czas; i++) {
	      try {
	        Thread.sleep(1000);
	      } catch(InterruptedException exc) {
	          System.out.println("Koniec czasu.");
	          return;
	      }
	      time++;
	      int sec = time%60;
	      System.out.println("Czas " + sec + ":");
	    }
	}
	
	public static void ktoWygral(Spiewak s1, Spiewak s2){
		if(s1.ileZnakow < s2.ileZnakow)
			System.out.println("Wygral " + s1.nazwisko);
		else
			if(s1.ileZnakow == s2.ileZnakow)
				System.out.println("Remis!");
			else
				System.out.println("Wygral " + s2.nazwisko);
		
	}
}
