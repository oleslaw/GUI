
public class SpiewakTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Spiewak sp1 = new Spiewak("Kowalski"){
			
			String spiewaj(){
				return "LalalLlalalalaLLLAa";
			}
		};
		
		Spiewak sp2 = new Spiewak("Nowak"){
			
			String spiewaj(){
				return "LalalaLLLALLLLLLLa";
			}
		};
		
		Spiewak sp3 = new Spiewak("Janowski"){
			
			String spiewaj(){
				return "Lalalalala";
			}
		};
		
			
		Spiewak[] tabSp = new Spiewak[] {sp1, sp2, sp3};
		
		for(Spiewak sp : tabSp){
			System.out.println(sp);
		}
		
		System.out.println("\nNajglosniej spiewa:");
		System.out.println(Spiewak.najglosniej(tabSp));
	}

}
