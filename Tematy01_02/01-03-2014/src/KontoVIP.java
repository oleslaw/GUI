
public class KontoVIP extends Konto {
	private int debet;
	private int probyPrzekroczenia;
	
	public KontoVIP(Osoba os, int opr, int debet){
		super(os, opr);
		this.debet = debet;
	}
	
	public void wyplata(int kwota){
		if((this.stanKonta-this.debet - kwota) < 0){
			System.out.println(this + " nie dozwolona wyplata!");
			this.probyPrzekroczenia++;
		}else
			this.stanKonta = this.stanKonta - kwota;
	}
	
	public void przelew(Rachunek rach, int kwota){
		if((this.stanKonta-this.debet - kwota) < 0){
			System.out.println(this + " nie dozwolony przelew!");
			this.probyPrzekroczenia++;
		}else{
			this.stanKonta = this.stanKonta - kwota;
			rach.wplata(kwota);
		}
	}
	
	public void aktualizuj(){
		//this.stanKonta = this.stanKonta*(1+this.oprocentowanie*0.01);
		System.out.println(this);
		if(this.probyPrzekroczenia > 0)
			System.out.println("Iloœæ prób przekroczenia debetu " + this.probyPrzekroczenia +"!");
	}
	
	public String toString(){
		return super.toString() + ", " + "limit debetu " + this.debet;
	}
}
