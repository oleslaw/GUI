import java.util.Arrays;


public class Bankomat {
	private String adres;
	private int[] obslugiwaneBanki;
	private double iloscPieniedzy;
	private int ile10;
	private int ile20;
	private int ile50;
	private int ile100;
	private int ile200;
	
	public Bankomat(int[] Banki, String adres){
		this.obslugiwaneBanki = Banki;
		iloscPieniedzy = 0;
		ile10 = 0;
		ile20 = 0;
		ile50 = 0;
		ile100 = 0;
		ile200 = 0;
		
		this.adres = adres;
	}
	
	public void dodajBank(int idBanku){
		if(obslugiwaneBanki == null)
			obslugiwaneBanki = new int[0];
		
		int[] nowaListaBankow = Arrays.copyOf(obslugiwaneBanki,  obslugiwaneBanki.length + 1);
		nowaListaBankow[obslugiwaneBanki.length] = idBanku;
		obslugiwaneBanki = nowaListaBankow;
	}
	
	public void usunBank(int idBanku){
		if(obslugiwaneBanki == null)
			obslugiwaneBanki = new int[0];
		
		int i = 0;
		
		for(int idObslugiwane : obslugiwaneBanki){
			if(idObslugiwane == idBanku){
				i++;
			}
		}
		
		int[] nowaListaBankow = new int[obslugiwaneBanki.length - i];
		
		int j = 0;
		for(int idObslugiwane : obslugiwaneBanki){
			if(idObslugiwane != idBanku){
				nowaListaBankow[j] = idObslugiwane;
				j++;
			}
		}
		
		obslugiwaneBanki = nowaListaBankow;
	}
	
	public double getiloscPieniedzy(){
		return this.iloscPieniedzy;
	}
	
	public void dodajNominaly(int add10, int add20, int add50, int add100, int add200){
		ile10 = add10;
		ile20 = add20;
		ile50 = add50;
		ile100 = add100;
		ile200 = add200;
		
		podliczIloscPieniedzy();
	}
	
	private void podliczIloscPieniedzy(){
		double suma = ile10 * 10. + ile20 * 20. + ile50 * 50. + ile100 * 100 + ile200 * 200.;
		iloscPieniedzy = suma;
	}
	
	public void wyplacPieniadze(Rachunek rach, int kwota){
		if(czyMoznaWyplacic(rach)){
			if(rach.getstanKonta() >= kwota && iloscPieniedzy >= kwota){
				rach.wyplata(kwota);
				this.wyplata(kwota);
				
				System.out.println();
			}else{
				if(iloscPieniedzy < kwota)
					System.out.println("Nie ma wystarczaj¹cej iloœci pieniêdzy w bankomacie!");
				else
					System.out.println("Konto nie ma wystarczaj¹cych œrodków!");
			}
		}else{
			System.out.println("Nie mo¿esz wyp³aciæ pieniêdzy z tego bankomatu!");
		}
	}
	
	public void wyplacPieniadze(Konto rach, int kwota){
		if(czyMoznaWyplacic(rach)){
			if(rach.getstanKonta() >= kwota && iloscPieniedzy >= kwota){
				rach.wyplata(kwota);
				this.wyplata(kwota);
			}else{
				if(iloscPieniedzy < kwota)
					System.out.println("Nie ma wystarczaj¹cej iloœci pieniêdzy w bankomacie!");
				else
					System.out.println("Konto nie ma wystarczaj¹cych œrodków!");
			}
		}else{
			System.out.println("Nie mo¿esz wyp³aciæ pieniêdzy z tego bankomatu!");
		}
	}
	
	public void wyplacPieniadze(KontoVIP rach, int kwota){
		if(czyMoznaWyplacic(rach)){
			if(rach.getstanKonta() >= kwota && iloscPieniedzy >= kwota){
				rach.wyplata(kwota);
				this.wyplata(kwota);
			}else{
				if(iloscPieniedzy < kwota)
					System.out.println("Nie ma wystarczaj¹cej iloœci pieniêdzy w bankomacie!");
				else
					System.out.println("Konto nie ma wystarczaj¹cych œrodków!");
			}
		}else{
			System.out.println("Nie mo¿esz wyp³aciæ pieniêdzy z tego bankomatu!");
		}
	}
	
	private boolean czyMoznaWyplacic(Rachunek rach){
		for(int id : obslugiwaneBanki){
			if(rach.getidentyfikatorBanku() == id)
				return true;
		}
		return false;
	}
	
	private boolean czyMoznaWyplacic(Konto rach){
		for(int id : obslugiwaneBanki){
			if(rach.getidentyfikatorBanku() == id)
				return true;
		}
		return false;
	}
	
	private boolean czyMoznaWyplacic(KontoVIP rach){
		for(int id : obslugiwaneBanki){
			if(rach.getidentyfikatorBanku() == id)
				return true;
		}
		return false;
	}
	
	private void wyplata(int kwota){
		int zapisKwoty = kwota;
		int[] nominaly = new int[] {10, 20, 50, 100, 200};
		int[] iloscBanknotow = new int[] {ile10, ile20, ile50, ile100, ile200};
		
		String opis = "";
		
		for(int i = nominaly.length-1; i >= 0; i--){
			double reszta = kwota % nominaly[i];
			iloscBanknotow[i] = kwota / nominaly[i];
			
			if(reszta == 0){
				kwota = 0;
			}else{
				kwota = kwota - iloscBanknotow[i] * nominaly[i];
			}
			
			opis += nominaly[i] + "z³ x " + iloscBanknotow[i] + "\n";
		}

		ile10 -= iloscBanknotow[0];
		ile20 -= iloscBanknotow[1];
		ile50 -= iloscBanknotow[2];
		ile100 -= iloscBanknotow[3];
		ile200 -= iloscBanknotow[4];
		
		podliczIloscPieniedzy();
		
		System.out.println("Wyplata kwoty " + zapisKwoty + " w postaci\n" + opis);
	}
	
	public String toString(){
		String banki = "";
		for(int id : obslugiwaneBanki){
			banki += id + " ";
		}
		
		String bankomat = "\n############\nAdres bankomatu: " + adres + "\n"
				+ "Obsluguje banki: " + banki + "\n"
				+ "Suma pieniedzy w bankomacie: " + getiloscPieniedzy() + "\n"
				+ "Nomina³y:\n10z³ x " + ile10 + "\n"
				+ "20z³ x " + ile20 + "\n"
				+ "50z³ x " + ile50 + "\n"
				+ "100z³ x " + ile100 + "\n"
				+ "200z³ x " + ile200 + "\n############\n";
		
		return bankomat;		
	}
}
