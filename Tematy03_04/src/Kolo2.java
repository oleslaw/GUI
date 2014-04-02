
public class Kolo2 extends Kolo implements Transformacja {
	int oryg_x;
	int oryg_y;
	
	public Kolo2(int x, int y, int r){
		super(x, y, r);
		
		oryg_x = this.x;
		oryg_y = this.y;
	}
	
	public void przesunDo(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void powrot(){
		this.x = oryg_x;
		this.y = oryg_y;
	}
}
