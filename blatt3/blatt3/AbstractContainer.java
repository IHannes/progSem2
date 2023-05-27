package blatt3;

public abstract class AbstractContainer implements Container{
	public boolean equals(Object o) {
		if(o.toString().equals(this.toString())) {
			return true;
		}
	return false;	
	}
	public String toString() {
		String s = new String();
		for(int i = 0; this.get(i)!=null; i++) {
			s+=this.get(i).toString();
			s+="\n";
		}
		return s;
	}
}
