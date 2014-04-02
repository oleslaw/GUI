
public class Prostokat extends Figura {
	protected int szer, wys;
	
	public Prostokat(int x, int y, int s, int w){
		super(x, y);
		szer = s;
		wys = w;
		fig = "Prostok�t";
	}
	
	public Prostokat(int x, int y, int s, int w, char c){
		this(x, y, s, w);
		znakRys = c;
	}
	
	public void pozycja(int x, int y){
		if((this.y > y && y < (this.y-wys)) && (this.x < x && (this.x + szer) > x)){
			System.out.println("Punkt (" + x + ", " + y + ") znajduje si� wewn�trz prostok�ta");
		}else{
			System.out.println("Punkt (" + x + ", " + y + ") znajduje si� na zewn�trz prostok�ta");
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
		return fig + "\n" + "Lewy g�rny - (" + x + ", " + y + ")\nSzeroko��: " + szer + ", Wysoko��: " + wys + "\n";
	}
}
