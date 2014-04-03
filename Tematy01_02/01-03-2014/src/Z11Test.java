
public class Z11Test {

	public static void main(String[] args) {
	      // tworzenie rachunków z stanem pocz¹tkowym
        Rachunek ror[] = new Rachunek[] {
            new Rachunek(new Osoba("firma 1")),                // stan pocz¹tkowy = 0
            new Rachunek(new Osoba("firma 2"), 1000000),        
            new Rachunek(new Osoba("firma 3"), 120000),        
            new Rachunek(new Osoba("firma 4"), 140000),
            new Rachunek(new Osoba("firma 5"), 100)
        };
        
        Thread kas[] = new Kasjer[] {
                new Kasjer(ror[0], 10, Kasjer.WPLATA, 10000),   // kasjer 1: 10000-krotna wp³ata kwoty 10 na konto firmy 1 
                new Kasjer(ror[0], 5, Kasjer.WPLATA, 10000),     // kasjer 2: 10000-krotna wp³ata kwoty 5 na konto firmy 1
                
                new Kasjer(ror[1], 50, Kasjer.WYPLATA, 10000),  // kasjer 3: 10000-krotna wyp³ata kwoty 50 z konta firmy 2
                new Kasjer(ror[1], 50, Kasjer.WYPLATA, 10000),  // kasjer 4: 10000-krotna wyp³ata kwoty 50 z konta firmy 2
                
                new Kasjer(ror[2], ror[3], 5, Kasjer.PRZELEW, 10000), // kasjer 5: 10000-krotny przelew kwoty 5 z konta firmy 3 na firmy 4
                new Kasjer(ror[3], ror[2], 5, Kasjer.PRZELEW, 10000),  // kasjer 6: 10000-krotny przelew kwoty 5 z konta firmy 4 na firmy 3
                
                new Kasjer(ror[3], 10, 123, 10000),   // kasjer 7: 10000-krotna operacja 123 (kwoty 10) dotycz¹ca firmy 4 - b³êdna operacja 123! 
                
                new Kasjer(ror[4], 10, Kasjer.WYPLATA, 200) // kasjer 8: 200-krotna wyp³ata kwoty 10 z konta firmy 5 - uda siê wykonaæ tylko 10 (z 200) operacji!
            };
        
        for (Thread k : kas)
            k.start();
        
            // czekanie na zakoñczenie wszystkich w¹tków
        try {
            for (Thread k : kas)
                k.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        
        // poprawne wyniki:      
        // firma 5, stan: 0.0 - niedozwolona operacja: wyp³ata!
        // Uda³o siê wykonaæ tylko 10 operacji: wyp³ata
        // B³êdna operacja!
        // firma 1, stan: 150000.0
        // firma 2, stan: 0.0
        // firma 3, stan: 120000.0
        // firma 4, stan: 140000.0
        // firma 5, stan: 0.0
        for (Rachunek r : ror) {
            System.out.println(r);
        }

	}

}
