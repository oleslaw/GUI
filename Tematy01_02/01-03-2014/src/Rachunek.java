
public class Rachunek {
	protected Osoba wlasciciel;
	protected double stanKonta;
	
	private static int ileKont;
	private int nrKonta;
	
	private int identyfikatorBanku;
	private String nazwaBanku;
	
	public Rachunek(){
		this.wlasciciel = new Osoba("---");
		this.stanKonta = 0;
	}
	
	public Rachunek(Osoba wlasciciel){
		this.wlasciciel = wlasciciel;
		this.stanKonta = 0;
		
		this.nrKonta = ++ileKont;
	}
	
	public Rachunek(Osoba wlasciciel, int stanKonta){
		this(wlasciciel);
		this.stanKonta = stanKonta;
	}
	
	public void setnazwaBanku(String nowaNazwa){
		this.nazwaBanku = nowaNazwa;
	}
	
	public void setidentyfikatorBanku(int nowyID){
		this.identyfikatorBanku = nowyID;
	}
	
	public String getnazwaBanku(){
		return this.nazwaBanku;
	}
	
	public int getidentyfikatorBanku(){
		return this.identyfikatorBanku;
	}
	
	public void wplata(int kwota){
		this.stanKonta = this.stanKonta + kwota;
	}
	
	public void wyplata(int kwota){
		if((this.stanKonta - kwota) < 0)
			System.out.println(this + " nie dozwolona wyplata!");
		else
			this.stanKonta = this.stanKonta - kwota;
	}
	
	public void przelew(Rachunek rach, int kwota){
		if((this.stanKonta - kwota) < 0)
			System.out.println(this + " nie dozwolony przelew!");
		else{
			this.stanKonta = this.stanKonta - kwota;
			rach.wplata(kwota);
		}
	}
	
	public double getstanKonta(){
		return this.stanKonta;
	}
	
	public String toString(){
		if(this.nazwaBanku == null){
			return "Konto nr " + this.nrKonta + ": " + this.wlasciciel + ", stan " + this.stanKonta;
		}else{
			return "Konto nr " + this.nrKonta + ": " + this.nazwaBanku + " (" + this.identyfikatorBanku + ") " + this.wlasciciel + ", stan " + this.stanKonta;
		}
	}
	
}
