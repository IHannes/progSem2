package blatt7.Aufgabe3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class XXD {
	public void processData(InputStream in, OutputStream out, int bytesPerRow) throws IOException {
		AddressOutputStream aout = new AddressOutputStream(out, 10);
		HexDumpOutputStream hout = new HexDumpOutputStream(out);
		AsciiOutputStream asout = new AsciiOutputStream(out);
		int ad = 0;
		byte[] arr = in.readAllBytes();
		while(ad+bytesPerRow<=arr.length) {
			aout.write(arr, ad+1, bytesPerRow-1);
			hout.write(arr, ad+1, bytesPerRow-1);
			asout.write(arr, ad+1, bytesPerRow-1);
			out.write('\n');
			ad+=bytesPerRow;
		}
		int r = arr.length -ad;
		if(arr.length%bytesPerRow !=0) {
			aout.write(arr, ad+1, bytesPerRow);
			hout.write(arr, ad, r);
			for(int i = 0; i<(bytesPerRow-r); i++) {
				if(i%2!=0) {
					out.write(' ');
					out.write(' ');
					out.write(' ');
				}else {
					out.write(' ');
					out.write(' ');
				}
			}
			out.write(' ');
			aout.write(arr, ad, r);
			for(int i = 0; i<(bytesPerRow-r); i++) {
				out.write(' ');
			}
			out.write('\n');
		}
	}

	public static void main(String[] args) {
		
	}
}	
