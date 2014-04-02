public class TestFigur {
    
    public static void main(String[] args)
    {        
        Figura fig[] = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);
        fig[1] = new Prostokat(20, 20, 15, 10);
       
            // polimorficzne wywo³anie metody toString() z klas Kolo/Prostokat,
            // a nie z klasy Figura
        for (Figura f : fig)              // pêtla for-each
            System.out.println(f);    // System.out.println(f.toString());
       
        fig[0].pozycja(12, 12);                     
        fig[1].pozycja(25, 30);
        
        System.out.println("\nPole ko³a: " + fig[0].obliczPole() + "\nObwod: " + fig[0].obliczObwod());
        System.out.println("Pole prostok¹ta: " + fig[1].obliczPole() + "\nObwod: " + fig[1].obliczObwod());
        
        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');        // prostok¹t rozmiaru 10 x 5 bêdzie "rysowany" na konsoli za pomoc¹ znaku '*'
        ((Prostokat2)p2).rysuj();                                          // Wyjaœniæ dlaczego p2.rysuj() nie dzia³a?
        
        
        Kolo2 k2 = new Kolo2(15, 20, 5);
        
        k2.przesunDo(50, 40);    // przesuniêcie œrodka ko³a do punktu (50, 40) 
        System.out.println(k2);
                
        k2.powrot();                    // powrót do poprzedniej pozycji œrodka ko³a
        System.out.println(k2);
        
        
        
    }
}