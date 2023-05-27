package blatt7.unittests.Aufgabe2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class AlternatingWordCapitalizerFilterTest {
	@Test
	public void testAlternatingWordCapitalizer()
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, InstantiationException {
		Class<?> capitalizerFilterClass = Class.forName("blatt7.Aufgabe2.AlternatingWordCapitalizerFilter");
		String input = "Dies ist ein Text mit mehreren Wörtern";
		String output = "DIES ist EIN text MIT mehreren WÖRTERN";
		CharArrayReader cr = new CharArrayReader(input.toCharArray());
		FilterReader reader = (FilterReader) capitalizerFilterClass.getConstructor(Reader.class).newInstance(cr);
		CharArrayWriter cw = new CharArrayWriter();
		reader.transferTo(cw);
		System.out.println(cw.toString());
		assertTrue(output.equals(cw.toString()));
	}
}
