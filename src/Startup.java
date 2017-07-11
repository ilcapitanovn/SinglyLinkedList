import SinglyLinkedList.*;

public class Startup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>();
		s.append(4);
		s.append(15);
		s.append(8);
		s.append(5);
		s.append(3);
		s.append(2);
		s.append(1);
		s.append(10);
		s.append(3);
		
		System.out.println(s.toString());
		
		s.removeTail();
		
		System.out.println(s.toString());
		
		s.removeGreatThan(6);
		
		System.out.println(s.toString());
	}

}
