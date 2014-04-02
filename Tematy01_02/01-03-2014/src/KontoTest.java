public class KontoTest {
	
    static Rachunek rekord(Rachunek[] konta)
    {
    		Rachunek najw = new Rachunek();
            for(Rachunek rach : konta){
            	if(najw.stanKonta < rach.stanKonta)
            		najw = rach;
            }
            return najw;
    }
  
    public static void main(String[] args)
    {
        Osoba klient1 = new Osoba("jan"), klient2 = new Osoba("anna");
        Osoba[] klienci = new Osoba[] {klient1, klient2, new Osoba("maria")};
        
        for (Osoba o: klienci)
            System.out.print(o + "  ");
        System.out.println("\n");
        
        Rachunek konto1 = new Rachunek(klient1); 
        Rachunek konto2 = new Konto(klient2, 5);    // oprocentowanie: 5%
        Rachunek[] konta = {konto1, 
                            konto2, 
                            new KontoVIP(klienci[2], 10, -100)};    // oprocentowanie: 10%, limit debetu: -100
        
        konto1.wplata(500);
        konto2.wplata(900);
        konto2.wyplata(300);
        konto1.przelew(konto2, 200);
        
        for (Rachunek k: konta)
            System.out.println(k);
        
        System.out.println();
        
        konta[2].wyplata(101);
        konto2.przelew(konta[2], 801);
        
        System.out.println();
        
        konto2.przelew(konta[2], 700);
        
        konta[2].przelew(konto1, 801);
        System.out.println();
        
        konta[2].przelew(konto1, 800);
         
        for (Rachunek k: konta)
            System.out.println(k);
        
        System.out.println();
        
        for (Rachunek k: konta){
            if (k instanceof Konto)
                ((Konto)k).aktualizuj();
        }
    
        System.out.println();
        
            // w³asna metoda rekord(...) z klasy Bank do napisania!
        System.out.println("Konto z najwiêkszym stanem - " + rekord(konta));    
    }
}         