package blatt7.Aufgabe1;

import java.util.ArrayList;
import java.util.Enumeration;

public class OrderedSet<E extends Comparable> extends AbstractSet<E>{
	ArrayList<E> al = new ArrayList<E>();

	@Override
	public boolean add(E element) {
		if(al.contains(element)) { 
			return false;
		}else {
			if(al.size()== 0) {
				al.add(element);
				return true;
			}
			for(int i = 1; i<=al.size(); i++) {
				if(al.size() == i) {
					al.add(element);
					return true;
				}else if(al.get(i-1).compareTo(element)<=0 && al.get(i).compareTo(element)>0){
					al.add(i, element);
					return true;
				}
			}
			return true;
		}
	}

	@Override
	public boolean test(E element) {
		return al.contains(element);
	}

	@Override
	public boolean remove(E element) {
		if(!al.contains(element)) {
			return false;
		}else {
			al.remove(element);
			return true;
		}
	}

	@Override
	public Enumeration<E> elements() {
		// TODO Auto-generated method stub
		return new Enumeration<>() {
			private int index = 0;
			@Override
			public boolean hasMoreElements() {
				return index<al.size() ? true :  false;
			}

			@Override
			public E nextElement() {
				index++;
				return al.get(index-1);
			}
			
		};
	}


}
