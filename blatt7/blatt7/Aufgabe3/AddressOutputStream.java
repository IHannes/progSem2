package blatt7.Aufgabe3;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AddressOutputStream extends FilterOutputStream {
	
	private int addressGap = 16;

	public AddressOutputStream(OutputStream out) {
		super(out);
	}
	
	public AddressOutputStream(OutputStream out, int addressGap) {
		super(out);
		this.addressGap = addressGap;
	}
	
	public void write(byte b[], int off, int len) throws IOException {
		String pos = new String();
		for(int i = off; i<=off + len; i++) {
			if(i>0 && i % addressGap == 0) {
				pos += String.format("%08x: ", i);
			}
		}
		out.write(pos.getBytes());
		
		
		
//		for(int i = 15, j = off; i < b.length; i++, j++) {
//			if(i % addressGap == 0) {
//				out.write(String.format("%08x", i).getBytes());
//				out.write(':');
//				out.write(' ');
//			}
////			System.out.println(j + " " +  b[j]);
//			out.write(b[j]);
//		}
    }

}