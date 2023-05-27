package blatt1;

public class List {
	listElement head = new listElement(null, null);
	
	public void pushFront(Object o) {
		listElement first = new listElement(head.next, o);
		head.next = first;
	}
	
	public Object popBack() {
		if(head.next == null) {
			return null;
		}
		listElement prev = head;
		listElement iter = head.next;
		while(iter.next != null) {
			prev = iter;
			iter = iter.next;
		}
		listElement tmp = prev.next;
		prev.next = null;
		return tmp.o;
	}
	
	public Object getFront() {
		return get(0);
	}
	
	public Object get(int index) {
		if(index >= length()) {
			return null;
		}
		listElement t = head.next;
		for(int i = 0; i<index; i++) {
			t = t.next;
		}
		return t.o;
	}
	
	public int length() {
		int i = 0;
		listElement lE = head.next;
		while(lE != null) {
			i++;
			lE = lE.next;
		}
		return i;
	}
	

	public static void printElements(List l) { 
		System.out.println("--------------");
		System.out.println(l.get(0));
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		System.out.println(l.length());		
	}
	
	public static void main(String[] args) {
		List l = new List();
		printElements(l);
		
		l.pushFront("Test");
		printElements(l);
		l.pushFront("Test2");
		printElements(l);;
		l.pushFront("Test3");
		printElements(l);
		
		System.out.println("Pop " + l.popBack());
		printElements(l);
		System.out.println("Pop " + l.popBack());
		printElements(l);
		l.pushFront("Neu");
		printElements(l);
		System.out.println("Pop " + l.popBack());
		printElements(l);
		System.out.println("Pop " + l.popBack());
		printElements(l);
		System.out.println("Pop " + l.popBack());
		printElements(l);
	}
}
