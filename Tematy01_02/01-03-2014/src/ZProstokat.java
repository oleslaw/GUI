
public class ZProstokat {
	private int szerokosc;
	private int wysokosc;
	private char znakSrodka;
	private char znakBrzegu;
	private static int currPr;
	private int liczbaProstokatow;
	private static int currKw;
	private int liczbaKwadratow;
	
	
	public ZProstokat(int szerokosc, int wysokosc,  char znakBrzegu, char znakSrodka){
		this.szerokosc = szerokosc;
		this.wysokosc = wysokosc;
		this.znakBrzegu = znakBrzegu;
		
		this.znakSrodka = znakSrodka;
		
		if (this.szerokosc == this.wysokosc)
			this.liczbaKwadratow = ++this.currKw;
		else
			this.liczbaProstokatow = ++this.currPr;

	}
	
	public ZProstokat(int szerokosc, char znakBrzegu, char znakSrodka){
		this(szerokosc, szerokosc, znakBrzegu, znakSrodka);
	}
	
	public String typ(){
		if (this.szerokosc == this.wysokosc)
				return "Kwadrat";
		else
				return "Prostok¹t";
	}
	
	public String numer(){
		if (this.szerokosc == this.wysokosc)
			return Integer.toString(this.liczbaKwadratow);
	else
			return Integer.toString(this.liczbaProstokatow);
	}
	
	public int pole(){
		return this.szerokosc*this.wysokosc;
	}
	
	public int obwod(){
		return 2*(this.szerokosc+this.wysokosc);
	}
	
	public String toString(){
		String opis =  this.typ() + " (numer: " + this.numer() + ") rozmiaru " + this.szerokosc + " x " + " " + this.wysokosc + ", pole = " + this.pole() + ", obwód = " + this.obwod();
	
		String obraz = "";
		
		for(int i = 0; i < this.wysokosc; i++){
			
			for(int j = 0; j < this.szerokosc; j++){
				if (i == 0 || i == this.wysokosc-1){
					obraz = obraz + this.znakBrzegu;
				}else{
					if(j == 0 || j == this.szerokosc-1){
						obraz = obraz + this.znakBrzegu;
					}else{
						obraz = obraz + this.znakSrodka;
					}
				}
			}
			
			obraz = obraz + "\n";
			
		}
		
		return opis + "\n" + obraz;
	}
}
