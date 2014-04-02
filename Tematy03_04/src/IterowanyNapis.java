import java.util.Iterator;

public class IterowanyNapis implements Iterable<Character> {
	String napis;
	private int poczatekIteracji = 0;
	private int krokIteracji = 1;
	
	public IterowanyNapis(String napis, int poczatekIteracji, int krokIteracji){
		this.napis = napis;
		this.poczatekIteracji = poczatekIteracji;
		this.krokIteracji = krokIteracji;
	}
	
	public IterowanyNapis(String napis){
		this.napis = napis;
	}
	
	public void ustawPoczatek(int poczatek){
		this.poczatekIteracji = poczatek;
	}
	
	public void ustawKrok(int krok){
		this.krokIteracji = krok;
	}
	
	public class NapisIterator implements Iterator<Character> {
		
		private int index;
		
		public NapisIterator(){
			index = poczatekIteracji;
		}
		
		@Override
		public boolean hasNext() {
			return napis.length() > index;
		}


		@Override
		public Character next() {
			index = index + krokIteracji;
			return napis.charAt(index-krokIteracji);
		}
		
		@Override
		public void remove() {
			StringBuilder sb = new StringBuilder(napis);
			sb.deleteCharAt(index);
			napis = sb.toString();
		}
		
	}
	
	public String toString(){
		return napis;
	}
	
	public Iterator<Character> iterator(){
		return new NapisIterator();
	}
}
