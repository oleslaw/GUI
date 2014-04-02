import java.util.Arrays;


public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank NBP = new Bank("Narodowy Bank Polski", 1010);
		Bank ING = new Bank("ING Bank Œl¹ski", 1050);
		Bank WBK = new Bank("Bank Zachodni WBK", 1090);
		Bank EuroBank = new Bank("Euro Bank SA", 1470);
		
		Bank[] Banki = new Bank[] {NBP, ING, WBK};
		
		for(Bank bank : Banki)
			System.out.println(bank);
		
		
		Rachunek rach1 = new Rachunek(new Osoba("Wladek"));
		rach1.wplata(254);
		
		Konto k1 = new Konto(new Osoba("Jan"), 5);
		k1.wplata(680);
		
		KontoVIP kv1 = new KontoVIP(new Osoba("Anna"), 10, -500);
		kv1.wplata(934);
		
		NBP.dodajRach(rach1);
		NBP.dodajRach(k1);
		ING.dodajRach(kv1);
		
		
		System.out.println(rach1);
		System.out.println(k1);
		System.out.println(kv1);
		
		Bankomat B1 = new Bankomat(new int[] {1010, 1090, 1500}, "Koszykowa");
		

		System.out.println(B1);
		
		B1.dodajNominaly(40, 30, 20, 15, 5);
		
		B1.dodajBank(1050);
		B1.usunBank(1500);
		
		System.out.println(B1);
		
		Rachunek rach2 = new Rachunek(new Osoba("Kamil"));
		rach2.wplata(6080);
		EuroBank.dodajRach(rach2);

		B1.wyplacPieniadze(k1, 180);
		B1.wyplacPieniadze(k1, 2000);
		
		B1.wyplacPieniadze(rach2, 100);
		
		System.out.println(k1);
		
		System.out.println(B1);
		

		
		
	}

}
