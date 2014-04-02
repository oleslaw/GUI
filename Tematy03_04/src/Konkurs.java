
public class Konkurs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // tworzenie obiektów - œpiewaków z podanymi "repertuarami"
	    Spiewak tenor = new Spiewak("Tenor") { 
	    	String spiewaj(){
	    		return "doremifasolasido";                        
	    	}
	    };
	    
	    Spiewak soprano = new Spiewak("Soprano") { 
	    	String spiewaj(){
	    		return "obladioblada"; 
	    	}    
		};
		
		Juror juror = new Juror(10);
		
		juror.start();
		
		tenor.start();
		soprano.start();
		
        try {
            juror.join();                   // wywo³anie metody join() z klasy java.lang.Thread: czekanie a¿ w¹tek jurora zakoñczy swoj¹ pracê
        } catch (InterruptedException e) { e.printStackTrace(); }
        finally{
                // wywo³anie metody interrupt() z klasy java.lang.Thread: przerwanie dzia³ania w¹tków - œpiewaków
            tenor.interrupt();                
            soprano.interrupt();
        }
        
        Juror.ktoWygral(tenor, soprano);
	}
}
