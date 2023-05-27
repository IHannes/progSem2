package blatt7.Aufgabe2;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class AlternatingWordCapitalizerFilter extends FilterReader{
private static Reader in;
private static 	CharArrayWriter cw = new CharArrayWriter();
	public AlternatingWordCapitalizerFilter(Reader in) {
		super(in);
		System.out.println(0);
		this.in = in;
	}
	
@Override
public int read(char[] cbuf, int off, int len) {
	int i = 0;
	try {
	i = in.read(cbuf, off, len);
	this.capitalize(cbuf);
	}catch(IOException e) {
		System.out.println(e);
	}
	return i;
}
public void capitalize(Reader reader, Writer writer) {
	System.out.println(1);
	StringBuilder str = new StringBuilder("");
	try {
		int i;
		while((i = reader.read())!=-1) {
			char c = (char) i;
			str.append(c);
		}
		String[] arr = str.toString().split(" ");
	StringBuilder strb = new StringBuilder("");
		for(int j = 0; j<arr.length; j+=2) {
			if(j==arr.length-1) {
				strb.append(arr[j].toUpperCase());
				break;
			}
			strb.append(arr[j].toUpperCase());
			strb.append(" ");
			strb.append(arr[j+1].toLowerCase());
			strb.append(" ");
		}
		writer.append(strb);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void capitalize(char[] ar) {
	String str = new String(ar);
	String[] arr = str.split(" ");
	StringBuilder strb = new StringBuilder("");
		for(int j = 0; j<arr.length; j+=2) {
			if(j==arr.length-1) {
				strb.append(arr[j].toUpperCase());
				break;
			}
			strb.append(arr[j].toUpperCase());
			strb.append(" ");
			strb.append(arr[j+1].toLowerCase());
			strb.append(" ");
		}
		char[] arrr = strb.toString().toCharArray();
		for(int i = 0; i<arrr.length; i++) {
			ar[i] = arrr[i];
		}
}
/*@Override
public long transferTo(Writer writer) {
	this.capitalize(in, writer);
	return 0;
}*/


}
