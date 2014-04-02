import java.util.Random;

public abstract class Spiewak extends Thread{
	public String nazwisko;
	public static int ileSpiewakow = 0;
	public int nrStartowy;
	public int ileZnakow;
	
	public Spiewak(String nazwisko){
		ileSpiewakow++;
		this.nrStartowy = ileSpiewakow;
		this.nazwisko = nazwisko;
	}
	
	abstract String spiewaj();
	
	public String toString(){
		return "Nazwisko: " + nazwisko + " nr startowy: " + nrStartowy + " spiew: " + this.spiewaj();
	}
	
	public static Spiewak najglosniej(Spiewak[] spiewacy){
		
		int max = 0;
		
		Spiewak najglosniejszy = spiewacy[0];

		for(int i = 0; i < spiewacy.length; i++){
			String spiew = spiewacy[i].spiewaj();
			int counter = 0;
			
			for(int j = 0; j < spiew.length(); j++){
				if(Character.isUpperCase(spiew.charAt(j))){
					counter++;
				}
			}
		
			if(max < counter){
				max = counter;
				najglosniejszy = spiewacy[i];
			}
		}
		
		return najglosniejszy;
	}
	
	public void run(){
		this.ileZnakow = 0;
		StringBuilder sb = new StringBuilder(this.spiewaj());
		Random generator = new Random();
		for(int i = 0; i < sb.length(); i++){
			try {
				this.sleep(generator.nextInt(2000) + 1);
			} catch (InterruptedException e) {
				System.out.println(this.nazwisko + " koniec spiewania");
				return;
			}
			System.out.println(this.nazwisko + " " + sb.charAt(i));
			ileZnakow++;
		}
	}
	
}
