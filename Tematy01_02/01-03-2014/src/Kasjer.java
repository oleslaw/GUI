

public class Kasjer extends Thread{
	
	public static final int WPLATA = 1;
	public static final int WYPLATA = 2;
	public static final int PRZELEW = 3;
	private int wybranaOperacja;
	private int kwota;
	private int ilePowtorzen;
	private Rachunek wybranyRach;
	private Rachunek odbiorcaPrzelewu;
	

	public Kasjer(Rachunek rach, int kwota, int operacja, int ilePowtorzen){
		this.wybranaOperacja = operacja;
		this.kwota = kwota;
		this.ilePowtorzen = ilePowtorzen;
		this.wybranyRach = rach;
	}
	
	public Kasjer(Rachunek rach, Rachunek odbiorcaPrzelewu, int kwota, int operacja, int ilePowtorzen){
		this(rach, kwota, operacja, ilePowtorzen);
		this.odbiorcaPrzelewu = odbiorcaPrzelewu;
	}
	
	synchronized public static void WPLATA(Rachunek rach, int ilePowtorzen, int kwota){
		for(int i = 0; i < ilePowtorzen; i++){
			rach.wplata(kwota);
		}
	}
	
	synchronized public static void WYPLATA(Rachunek rach, int ilePowtorzen, int kwota){
		int ileUdanych = 0;
		for(int i = 0; i < ilePowtorzen; i++){
			if(rach.stanKonta >= kwota){
				rach.wyplata(kwota);
				ileUdanych++;
			}else{
				System.out.println("Uda³o siê wykonaæ tylko " + ileUdanych + " operacji: wyp³ata");
				break;
			}
		}
	}
	
	synchronized public static void PRZELEW(Rachunek nadawcaPrzelewu, Rachunek odbiorcaPrzelewu, int ilePowtorzen, int kwota){
		int ileUdanych = 0;
		for(int i = 0; i < ilePowtorzen; i++){
			if(nadawcaPrzelewu.stanKonta >= kwota){
				nadawcaPrzelewu.przelew(odbiorcaPrzelewu, kwota);
				ileUdanych++;
			}else{
				System.out.println("Uda³o siê wykonaæ tylko " + ileUdanych + " operacji: wyp³ata");
				break;
			}
		}
	}
	
	public void run(){
		if(wybranaOperacja == WPLATA){
			WPLATA(wybranyRach, ilePowtorzen, kwota);
		}else if(wybranaOperacja == WYPLATA){
			WYPLATA(wybranyRach, ilePowtorzen, kwota);
		}else if(wybranaOperacja == PRZELEW){
			PRZELEW(wybranyRach, odbiorcaPrzelewu, ilePowtorzen, kwota);
		}else{
			System.out.println("B³êdna operacja!");
		}
	}
	
	
}