public class TestFigur {
    
    public static void main(String[] args)
    {        
        Figura fig[] = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);
        fig[1] = new Prostokat(20, 20, 15, 10);
       
            // polimorficzne wywo�anie metody toString() z klas Kolo/Prostokat,
            // a nie z klasy Figura
        for (Figura f : fig)              // p�tla for-each
            System.out.println(f);    // System.out.println(f.toString());
       
        fig[0].pozycja(12, 12);                     
        fig[1].pozycja(25, 30);
        
        System.out.println("\nPole ko�a: " + fig[0].obliczPole() + "\nObwod: " + fig[0].obliczObwod());
        System.out.println("Pole prostok�ta: " + fig[1].obliczPole() + "\nObwod: " + fig[1].obliczObwod());
        
        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');        // prostok�t rozmiaru 10 x 5 b�dzie "rysowany" na konsoli za pomoc� znaku '*'
        ((Prostokat2)p2).rysuj();                                          // Wyja�ni� dlaczego p2.rysuj() nie dzia�a?
        
        
        Kolo2 k2 = new Kolo2(15, 20, 5);
        
        k2.przesunDo(50, 40);    // przesuni�cie �rodka ko�a do punktu (50, 40) 
        System.out.println(k2);
                
        k2.powrot();                    // powr�t do poprzedniej pozycji �rodka ko�a
        System.out.println(k2);
        
        
        
    }
}