package shop;

public class DoubleLinkedList extends AbstractContainer{
	listElement first;
	listElement last;
	@Override
	public boolean add(Object o){
		if(first==null) {
			first = new listElement(null, null, o);
		}
		else if(first.next==null) {
			first.next=new listElement(first, null, o);
		}
		else {
			listElement iter = first.next;
			listElement prev = first;
			while(iter.next!=null) {
				prev = iter;
				iter = iter.next;
			}
			iter.next = new listElement(prev, null, o);
			last = iter;
		}
		return true;
	}

	@Override
	public Object get(int i){
		if(first ==null) {
			return null;
		}
		listElement iter = first;
		for(int j=0; j<i; j++) {
			if(iter.next==null){
				return null;
			}
			iter = iter.next;
		}
		if(iter.o==null) return null;
		return iter.o;
	}

	@Override
	public boolean remove(Object o){
		listElement iter = first;
		if(first.o.equals(o)) {
			first = first.next;
			return true;
		}
		while(iter.next!=null) {
			if(iter.next.o.equals(o)) {
				if(iter.next!=null) {
					iter.next = iter.next.next;
					return true;
				}
				else {
					iter.next = null;
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
	}
	public Object getFirst() {
		return first;
	}
class listElement{
	public listElement previous;
	public listElement next;
	public Object o;
	
	public listElement(listElement previous, listElement next, Object o) {
		this.previous = previous;
		this.next = next;
		this.o = o;
	}
}
}
