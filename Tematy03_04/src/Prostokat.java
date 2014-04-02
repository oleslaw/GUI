
public class Prostokat extends Figura {
	protected int szer, wys;
	
	public Prostokat(int x, int y, int s, int w){
		super(x, y);
		szer = s;
		wys = w;
		fig = "Prostok¹t";
	}
	
	public Prostokat(int x, int y, int s, int w, char c){
		this(x, y, s, w);
		znakRys = c;
	}
	
	public void pozycja(int x, int y){
		if((this.y > y && y < (this.y-wys)) && (this.x < x && (this.x + szer) > x)){
			System.out.println("Punkt (" + x + ", " + y + ") znajduje siê wewn¹trz prostok¹ta");
		}else{
			System.out.println("Punkt (" + x + ", " + y + ") znajduje siê na zewn¹trz prostok¹ta");
		}
	}
	
	public void rysuj(){
		
	}
	
	public double obliczPole(){
		return szer*wys;
	}
	
	public double obliczObwod(){
		return 2*(szer+wys);
	}
	
	public String toString(){
		return fig + "\n" + "Lewy górny - (" + x + ", " + y + ")\nSzerokoœæ: " + szer + ", Wysokoœæ: " + wys + "\n";
	}
}
