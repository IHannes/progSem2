package blatt7.Aufgabe3;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HexDumpOutputStream extends FilterOutputStream{

	public HexDumpOutputStream(OutputStream out) {
		super(out);
	}
	public void write(byte[] buf, int pos, int len) {
		String str = "";
		for(int i = pos; i<=pos+len; i+=2) {
			if(buf.length>i) {
			str += String.format("%02x", buf[i]);
			if(i+1<buf.length)
			str += String.format("%02x", buf[i+1]);
			str +=" ";
			}
		}
	try {
		out.write(str.substring(0, str.length()-1).getBytes());
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
