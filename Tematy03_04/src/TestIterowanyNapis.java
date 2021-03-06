public class TestIterowanyNapis {

    public static void main(String [] args) 
    {
        IterowanyNapis napis = new IterowanyNapis("proGrAmOwAnIe oBiEkToWe i gUi");

            // iteracja po znakach napisu,
            // domyślnie zaczynając od pierwszego znaku (o indeksie 0)
            // i z krokiem iteracji = 1
        for (char z: napis) 
            System.out.print(z + " ");
    
        System.out.println();

        napis.ustawPoczatek(3);     // ustawienie początku iteracji (tu: 3-gi znak, o indeksie 3)
        napis.ustawKrok(2);           // ustawienie kroku iteracji (tu: co 2-gi znak)
    
            // iteracja po znakach napisu,
            // od ustalonego znaku, z określonym krokiem
        for (char z: napis) 
            System.out.print(z + " ");

    }
}