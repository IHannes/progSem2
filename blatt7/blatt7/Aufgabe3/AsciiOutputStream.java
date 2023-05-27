package blatt7.Aufgabe3;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AsciiOutputStream extends FilterOutputStream{
private int ad;

	public AsciiOutputStream(OutputStream out) {
		super(out);
	}
	public void write(byte[] bytes, int a, int b) throws IOException {
		int[] arr = new int[bytes.length];
		for(int i = 0; i<bytes.length; i++) {
			arr[i] = Byte.toUnsignedInt(bytes[i]);
		}
		StringBuilder s = new StringBuilder("");
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]>=32 && arr[i]<=126) {
				s.append((char) ((char)arr[i]));
			}
			else {
				s.append('.');
			}
		}
		out.write(s.toString().getBytes());
	}
}
