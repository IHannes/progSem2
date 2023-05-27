package blatt7.Aufgabe1;

import java.util.ArrayList;
import java.util.Enumeration;

public class NormalSet<E> extends AbstractSet<E>{
ArrayList<E> al = new ArrayList<E>();

	@Override
	public boolean add(E element) {
		if(al.contains(element)) {
			return false;
		}else {
			al.add(element);
			return true;
		}
	}

	@Override
	public boolean test(E element) {
		return al.contains(element) ? true : false;
	}

	@Override
	public boolean remove(E element) {
		if(!al.contains(element)) {
			return false;
		}
		al.remove(element);
		return true;
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
