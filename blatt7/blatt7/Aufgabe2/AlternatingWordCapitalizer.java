package blatt7.Aufgabe2;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class AlternatingWordCapitalizer {
	private static 	CharArrayWriter cw = new CharArrayWriter();
public static void capitalize(Reader reader, Writer writer) {
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
public static void main(String[] args) {
	String input = "Dies ist ein Test mit anderen Wörtern";
	CharArrayReader cr = new CharArrayReader(input.toCharArray());
	capitalize(cr, cw);
	System.out.print(cw.toString());
	}
}
