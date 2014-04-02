
public class PunktOdcinekTest {
	
    static Odcinek najdluzszy(Odcinek[] odcinki)
    {
    		Odcinek najdl = new Odcinek(new Punkt(0.,0.), new Punkt(0.,0.));
    		
            for(Odcinek od : odcinki){
            	if(od.dlugosc() > najdl.dlugosc())
            		najdl = od;
            }
            
            return najdl;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Punkt p1 = new Punkt(0,0), p2 = new Punkt(4,3), p3 = new Punkt(2,3), p4 = new Punkt(4,0);
        Odcinek od1 = new Odcinek(p1, p2), od2 = new Odcinek(p1, p4);
        Odcinek[] odcinki = {od1, od2, new Odcinek(p3, p4)};
        
        for (Odcinek od : odcinki)
            System.out.println(od);

        System.out.println("D³ugoœæ odcinka " + od1.numer() + " = " + od1.dlugosc());
        System.out.println("Odleg³oœæ od punktu " +  p3 + " do œrodka odcinka " + od2.numer() + " = " + od2.odleglosc(p3));
        System.out.println("Krótszy odcinek to " + od2.krotszy(odcinki[2]));

        System.out.println("Rzut odcinka " + od1 + " na X to " + od1.rzutX());
        System.out.println("Rzut odcinka " + od1 + " na Y to " + od1.rzutY());
        
        System.out.println("Najd³u¿szy odcinek to " + najdluzszy(odcinki));
	}

}
