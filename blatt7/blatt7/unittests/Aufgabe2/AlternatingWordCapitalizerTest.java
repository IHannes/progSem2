package blatt7.unittests.Aufgabe2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class AlternatingWordCapitalizerTest {
	@Test
	public void testAlternatingWordCapitalizer()
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> capitalizerClass = Class.forName("blatt7.Aufgabe2.AlternatingWordCapitalizer");
		Method method = capitalizerClass.getMethod("capitalize", Reader.class, Writer.class);
		assertTrue(Modifier.isStatic(method.getModifiers()));
		String input = "Dies ist ein Text mit mehreren Wörtern";
		String output = "DIES ist EIN text MIT mehreren WÖRTERN";
		CharArrayReader cr = new CharArrayReader(input.toCharArray());
		CharArrayWriter cw = new CharArrayWriter();
		method.invoke(null, cr, cw);
		assertTrue(output.equals(cw.toString()));
	}

	@Test
	public void testMain() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> capitalizerClass = Class.forName("blatt7.Aufgabe2.AlternatingWordCapitalizer");
		Method method = capitalizerClass.getMethod("main", String[].class);
		PrintStream oldOut = System.out;
		InputStream oldIn = System.in;
		System.setIn(new InputStream() {
			int index;
			byte[] bytes = "Dies ist ein Test mit anderen Wörtern".getBytes();

			@Override
			public int read() throws IOException {
				if (index < bytes.length)
					return bytes[index++];
				return -1;
			}
		});
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(bos));
		
		// o = capitalizerClass.getConstructor().newInstance();
		String[] params = null;
		method.invoke(null, (Object)params);
		System.setOut(oldOut);
		System.setIn(oldIn);
		assertEquals("DIES ist EIN test MIT anderen WÖRTERN", bos.toString());

		
	}
}
