
public abstract class Figura implements Obliczenie, Rysowanie, Comparable<Figura> {
	protected int x, y;
	protected String fig = "Nie wiadomo";
	
	protected static int ileFigur = 0;
	protected int nrFigury;
	protected char znakRys;
	
	public Figura(int x, int y){
		this.x = x;
		this.y = y;
		ileFigur++;
		nrFigury = ileFigur;
	}
	
	public abstract void pozycja(int x, int y);
	
	public String toString(){
		return fig + "\n" + "Œrodek - (" + x + ", " + y + ")";
	}
	
	public int compareTo(Figura fig){
		if(this.obliczPole() < fig.obliczPole())
			return -1;
		if(this.obliczPole() == fig.obliczPole()){
			if(this.obliczObwod() < fig.obliczObwod())
				return -1;
			if(this.obliczObwod() == fig.obliczObwod()){
				if(this.getnrFigury() < fig.getnrFigury())
					return -1;
				if(this.getnrFigury() == fig.getnrFigury())
					return 0;
			}
		}
		return 1;
	}
	
	public int getnrFigury(){
		return this.nrFigury;
	}


}
