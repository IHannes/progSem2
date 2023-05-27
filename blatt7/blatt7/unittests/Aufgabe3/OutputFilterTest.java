package blatt7.unittests.Aufgabe3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;

public class OutputFilterTest {
	private void testFilterClass(String name) throws Throwable {
		Class<?> clazz = Class.forName(name);
		assertEquals(FilterOutputStream.class, clazz.getSuperclass());
	}
	
	@Test
	public void testFilterClasses() throws Throwable {
		testFilterClass("blatt7.Aufgabe3.AddressOutputStream");
		testFilterClass("blatt7.Aufgabe3.HexDumpOutputStream");
		testFilterClass("blatt7.Aufgabe3.AsciiOutputStream");
	}
	
	@Test
	public void testAddressOutputStream() throws Throwable {
		Class<?> clazz = Class.forName("blatt7.Aufgabe3.AddressOutputStream");
		clazz.getConstructor(OutputStream.class);
		ByteArrayInputStream bis = new ByteArrayInputStream(new byte[50]);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		OutputStream instance = (OutputStream)clazz.getConstructor(OutputStream.class).newInstance(bos);
		bis.transferTo(instance);
		assertEquals("00000010: 00000020: 00000030: ", bos.toString());
		bos.reset();
		bis = new ByteArrayInputStream(new byte[50]);
		instance = (OutputStream)clazz.getConstructor(OutputStream.class, int.class).newInstance(bos, 10);
		bis.transferTo(instance);
		assertEquals("0000000a: 00000014: 0000001e: 00000028: 00000032: ", bos.toString());

	}
	
	@Test
	public void testHexDumpOutputStream() throws Throwable {
		Class<?> clazz = Class.forName("blatt7.Aufgabe3.HexDumpOutputStream");
		ByteArrayInputStream bis = new ByteArrayInputStream(new byte[] { (byte)0x01, (byte)0xab, (byte)0x10, (byte)0xab, (byte)0x44, (byte) 0xef, (byte)0xff, (byte)0x33, (byte)0x00});
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		OutputStream instance = (OutputStream)clazz.getConstructor(OutputStream.class).newInstance(bos);
		bis.transferTo(instance);
		assertEquals("01ab 10ab 44ef ff33 00", bos.toString());
	}
	
	@Test
	public void testAsciiOutputStream() throws Throwable {
		Class<?> clazz = Class.forName("blatt7.Aufgabe3.AsciiOutputStream");
		ByteArrayInputStream bis = new ByteArrayInputStream(new byte[] { (byte)'T', (byte)'E', (byte)'S', (byte)'T', (byte)0x01, (byte)0xab, (byte)0x10, (byte)0xab, (byte)0x44, (byte) 0xef, (byte)0xff, (byte)0x33, (byte)0x00});
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		OutputStream instance = (OutputStream)clazz.getConstructor(OutputStream.class).newInstance(bos);
		bis.transferTo(instance);
		assertEquals("TEST....D..3.", bos.toString());

	}
}
