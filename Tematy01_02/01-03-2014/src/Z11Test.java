
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
        
        new Kasjer(ror[0], 10, Kasjer.WPLATA, 10000);

	}

}
