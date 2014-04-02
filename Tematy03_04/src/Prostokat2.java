
public class Prostokat2 extends Prostokat {
	
	public Prostokat2(int x, int y, int s, int w, char c){
		super(x, y, s, w, c);
	}
	
	public void rysuj(){
		for(int i = 0; i < this.wys; i++){
			for(int j = 0; j < this.szer; j++){
				if(j == this.szer-1)
					System.out.println();
				else
					System.out.print(this.znakRys);
			}
		}
	}
}
