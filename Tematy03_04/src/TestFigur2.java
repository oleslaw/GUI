import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFigur2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Prostokat p1 = new Prostokat(1, 1, 4, 9);
		Kolo k1 = new Kolo(1, 1, 5);
		Prostokat p2 = new Prostokat(2, 2, 6, 6);
		
		List list = new ArrayList();
		
		list.add(p1);
		list.add(k1);
		list.add(p2);
		
		for(Object fig : list){
			System.out.println(fig);
		}
		
		Collections.sort(list);
		System.out.println("Po sortowaniu:\n");
		
		for(Object fig : list){
			System.out.println(fig);
		}
	}

}
