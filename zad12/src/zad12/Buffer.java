package zad12;

public class Buffer {
	private int[] storage = new int[5];
	private int currPos = 0;
	boolean isFull = false;
	boolean isEmpty = true;
	
	public Buffer(){
		
	}
	
	public int get(){
		while(isEmpty){
			try {
				wait();
			} catch(InterruptedException exc){}
		}
		int topNr = 0;
		if(currPos > 0){
			currPos--;
			isEmpty = false;
			topNr = storage[currPos];
		}else if(currPos == 0){
			isEmpty = true;
			topNr = storage[currPos];
		}
		storage[currPos] = 0;
		return topNr;
	}
	
	public void put(int p){
		while(isFull){
			try {
				wait();
			} catch(InterruptedException exc){}
		}
		if(currPos == storage.length){
			isFull = true;
			isEmpty = false;
		}else{
			this.storage[currPos] = p;
			currPos++;
			isFull = false;
			isEmpty = false;
		}
	}
	
	public String toString(){
		String buff = "Bufor:\t";
		for(int i = 0; i < storage.length; i++){
			buff += storage[i] + "\t";
		}
		return buff;
	}
}
