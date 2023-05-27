package blatt3;

public class Vector extends AbstractContainer{
Object[] obj;
	@Override
	public boolean add(Object o) {
		if(obj ==null) {
			obj = new Object[1];
			obj[0] = o;
			return true;
		}
		Object temp[] = new Object[obj.length];
		for(int i = 0; i<temp.length; i++) {
			temp[i] = obj[i];
		}
		obj = new Object[temp.length + 1];
		for(int i = 0; i<temp.length; i++) {
			obj[i] = temp[i];
		}
		obj[obj.length-1] = o;
		return true;
	}

	@Override
	public Object get(int i) {
		if(obj==null) return null;
		if(obj.length>i) {
		return obj[i];
		}
		return null;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o, obj);
		for(int i = index; i<obj.length-1; i++) {
			obj[i]=obj[i+1];
		}
		obj[obj.length-1]=null;
		Object[] tmp = new Object[obj.length-1];
		for(int i = 0; i<tmp.length; i++) {
			tmp[i] = obj[i];
		}
		obj = new Object[tmp.length];
		for(int i = 0; i<obj.length; i++) {
			obj[i]=tmp[i];
		}
		return true;
	}

	@Override
	public void clear() {
		obj = new Object[0];
	}
	private static int indexOf(Object o, Object[] obj) {
		for(int i = 0; i<obj.length; i++) {
			if(obj[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
}
