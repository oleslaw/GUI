public class ZProstokatTest {

    public static void main(String[] args)
    {
          ZProstokat p1 = new ZProstokat(4, 'e', 'a');        // konstruktor z 3 parametrami
          ZProstokat p2= new ZProstokat(5, 3, '+', '*');    // konstruktor z 4 parametrami
          ZProstokat p3 = new ZProstokat(3, 3, 'x', '+');
          ZProstokat p4= new ZProstokat(3, 4, '$', '^');
          
          System.out.println(p1);        
          System.out.println(p2);
          System.out.println(p3);        
          System.out.println(p4);
   }
}