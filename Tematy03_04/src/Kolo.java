
public class Kolo extends Figura {
	private int promien;
	
	public Kolo(int x, int y, int r){
		super(x, y);
		promien = r;
		fig = "Ko�o";
	}
	
	public Kolo(int x, int y, int r, char c){
		this(x, y, r);
		znakRys = c;
	}
	
	public void pozycja(int x, int y){
		double od = Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
		
		if(od <= promien){
			System.out.println("Punkt (" + x + ", " + y + ") znajduje si� wewn�trz ko�a");
		}else{
			System.out.println("Punkt (" + x + ", " + y + ") znajduje si� na zewewn�trz ko�a");
		}
	}
	
	public void rysuj(){
		//rysowanie
	}
	
	public double obliczPole(){
		return Math.PI*Math.pow(promien, 2);
	}
	
	public double obliczObwod(){
		return 2*Math.PI*promien;
	}
	
	public String toString(){
		return super.toString() + "\nPromie� - " + promien + "\n";
	}
}
