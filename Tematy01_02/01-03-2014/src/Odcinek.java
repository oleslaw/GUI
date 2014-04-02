
public class Odcinek {
	private Punkt p1;
	private Punkt p2;
	
	private static int liczbaOdcinkow;
	private int nrOdcinka;
	
	public Odcinek(Punkt p1, Punkt p2){
		this.p1 = p1;
		this.p2 = p2;
		
		this.nrOdcinka = ++liczbaOdcinkow;
		
	}
	
	private Odcinek(Punkt p1, Punkt p2, boolean bool){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public double dlugosc(){
		double wynik = Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
		return wynik;
	}
	
	public Punkt srodek(){
		Punkt srodek = new Punkt((p1.x+p2.x)/2, (p1.y+p2.y)/2);
		return srodek;
	}
	
	public int numer(){
		return this.nrOdcinka;
	}
	
	public String krotszy(Odcinek od){
		if (this.dlugosc() > od.dlugosc())
			return od.toString();
		else{
			if (this.dlugosc() == od.dlugosc())
				return "Odcinek " + this + " i " + od + " sa rowne.";
			else
				return this.toString();
		}
	}
	
	public double odleglosc(Punkt p){
		return new Odcinek(this.srodek(), p, true).dlugosc();
	}
	
	public Odcinek rzutX(){
		Odcinek rzut = new Odcinek(new Punkt(p1.x, 0.), new Punkt(p2.x, 0.));
		return rzut;
	}
	
	public Odcinek rzutY(){
		Odcinek rzut = new Odcinek(new Punkt(0., p1.y), new Punkt(0., p2.y));
		return rzut;
	}
	
	public String toString(){
		return this.nrOdcinka + ":" + this.p1 + "-" + this.p2;
	}
}
