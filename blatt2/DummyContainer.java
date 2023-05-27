package blatt2;

import java.util.ArrayList;
import java.util.LinkedList;

public class DummyContainer implements Container {
	private java.util.List<Object> arrayList = new ArrayList<>();
	
	@Override
	public boolean add(Object o) {
		return arrayList.add(o);
	}

	@Override
	public Object get(int i) {
		return arrayList.get(i);
	}

	@Override
	public int size() {
		return arrayList.size();
	}

	@Override
	public boolean remove(Object o) {
		return arrayList.remove(o);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
