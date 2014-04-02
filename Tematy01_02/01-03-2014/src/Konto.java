
public class Konto extends Rachunek {
	protected double oprocentowanie;
	
	public Konto(){
		this.oprocentowanie = 0;
	}
	
	public Konto(Osoba os, int opr){
		super(os);
		this.oprocentowanie = opr;
	}
	
	public void aktualizuj(){
		this.stanKonta = this.stanKonta*(1+this.oprocentowanie*0.01);
		System.out.println(this);
	}
	
	public String toString(){
		return super.toString() + ", " + "oprocentowanie " + this.oprocentowanie;
	}
}
