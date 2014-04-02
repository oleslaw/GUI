import java.util.Arrays;


public class Bank {
	public String nazwa;
	public int	identyfikatorBanku;
	public static int[] wszystkieBanki;
	private Konto[] konta;
	private Rachunek[] rachunki;
	private KontoVIP[] kontaVip;

	
	public Bank(String nazwa, int identyfikatorBanku){
		if(wszystkieBanki == null)
			wszystkieBanki = new int[0];
		
		if(isInDB(wszystkieBanki, identyfikatorBanku)){
			System.out.println("Wybrany identyfikator ju¿ istnieje, wybierz inny!");
		}else{
			int[] nowaLista = Arrays.copyOf(wszystkieBanki, wszystkieBanki.length + 1);
			nowaLista[wszystkieBanki.length] = identyfikatorBanku;
			wszystkieBanki = nowaLista;
			
			this.nazwa = nazwa;
			this.identyfikatorBanku = identyfikatorBanku;
		}
	}
	
	private boolean isInDB(int[] arr, int value){
		for(int db_val : arr){
			if(db_val == value)
				return true;
		}
		return false;
	}
	
	public void dodajRach(Konto konto){
		if(konta == null)
			konta = new Konto[0];
		
		Konto[] powiekszoneKonta = Arrays.copyOf(konta,  konta.length + 1);
		powiekszoneKonta[konta.length] = konto;
		konta = powiekszoneKonta;
		
		konto.setidentyfikatorBanku(this.identyfikatorBanku);
		konto.setnazwaBanku(this.nazwa);
	}
	
	public void dodajRach(Rachunek rachunek){
		if(rachunki == null)
			rachunki = new Rachunek[0];
		
		Rachunek[] powiekszoneRachunki = Arrays.copyOf(rachunki,  rachunki.length + 1);
		powiekszoneRachunki[rachunki.length] = rachunek;
		rachunki = powiekszoneRachunki;
		
		rachunek.setidentyfikatorBanku(this.identyfikatorBanku);
		rachunek.setnazwaBanku(this.nazwa);
	}
	
	public void dodajRach(KontoVIP konto){
		if(kontaVip == null)
			kontaVip = new KontoVIP[0];
		
		KontoVIP[] powiekszoneKontaVip = Arrays.copyOf(kontaVip,  kontaVip.length + 1);
		powiekszoneKontaVip[kontaVip.length] = konto;
		kontaVip = powiekszoneKontaVip;
		
		konto.setidentyfikatorBanku(this.identyfikatorBanku);
		konto.setnazwaBanku(this.nazwa);
	}
	
	public String toString(){
		return nazwa + " " + "(" + identyfikatorBanku + ")";
	}
}
