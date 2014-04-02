
public class Konkurs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // tworzenie obiekt�w - �piewak�w z podanymi "repertuarami"
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
            juror.join();                   // wywo�anie metody join() z klasy java.lang.Thread: czekanie a� w�tek jurora zako�czy swoj� prac�
        } catch (InterruptedException e) { e.printStackTrace(); }
        finally{
                // wywo�anie metody interrupt() z klasy java.lang.Thread: przerwanie dzia�ania w�tk�w - �piewak�w
            tenor.interrupt();                
            soprano.interrupt();
        }
        
        Juror.ktoWygral(tenor, soprano);
	}
}
