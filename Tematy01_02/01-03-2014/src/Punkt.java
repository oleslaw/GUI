
public class Punkt {
	public double x;
	public double y;

	public Punkt(double _x, double _y){
		this.x = _x;
		this.y = _y;
	}
	
	public String toString(){
		return "[" + this.x + "," + this.y + "]";
	}
}
