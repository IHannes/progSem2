package blatt7.unittests.Aufgabe3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class XXDTest {
	private String input1 = "TESTäüƒMehr Tests in der Ä😀 😃 😄 😁 😆 😅😂 🤣FEASDF FERWF";
	private String output1 = "00000010: 5445 5354 c3a4 c3bc c692 4d65 6872 2054 TEST......Mehr T\n"
			+ "00000020: 6573 7473 2069 6e20 6465 7220 c384 f09f ests in der ....\n"
			+ "00000030: 9880 20f0 9f98 8320 f09f 9884 20f0 9f98 .. .... .... ...\n"
			+ "00000040: 8120 f09f 9886 20f0 9f98 85f0 9f98 8220 . .... ........ \n"
			+ "00000050: f09f a4a3 4645 4153 4446 2046 4552 5746 ....FEASDF FERWF\n";
	private String input2 = "TESTäüƒM";
	private String output2 = "0000000a: 5445 5354 c3a4 c3bc c692 TEST......\n"
			+ "00000014: 4d                       M         \n";

	@Test
	public void testXXDClass() throws Throwable {
		Class<?> xxdClass = Class.forName("blatt7.Aufgabe3.XXD");
		Method method = xxdClass.getMethod("main", String[].class);
		assertTrue(Modifier.isStatic(method.getModifiers()));
		assertTrue(Modifier.isPublic(method.getModifiers()));
		method = xxdClass.getMethod("processData", InputStream.class, OutputStream.class, int.class);
		assertFalse(Modifier.isStatic(method.getModifiers()));
		assertTrue(Modifier.isPublic(method.getModifiers()));
	}

	@Test
	public void testProcessData() throws Throwable {
		ByteArrayInputStream bis = new ByteArrayInputStream(input1.getBytes());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Class<?> xxdClass = Class.forName("blatt7.Aufgabe3.XXD");
		Object o = xxdClass.getConstructor().newInstance();
		Method method = xxdClass.getMethod("processData", InputStream.class, OutputStream.class, int.class);
		method.invoke(o, bis, bos, 16);
		assertEquals(output1, bos.toString());
	}

	@Test
	public void testProcessDataNotAlignedInput() throws Throwable {
		ByteArrayInputStream bis = new ByteArrayInputStream(input2.getBytes());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Class<?> xxdClass = Class.forName("blatt7.Aufgabe3.XXD");
		Object o = xxdClass.getConstructor().newInstance();
		Method method = xxdClass.getMethod("processData", InputStream.class, OutputStream.class, int.class);
		method.invoke(o, bis, bos, 10);
		assertEquals(output2, bos.toString());
	}

	@Test
	public void testMainWithoutArguments() throws Throwable {
		PrintStream oldOut = System.out;
		InputStream oldIn = System.in;
		try {
			Class<?> xxdClass = Class.forName("blatt7.Aufgabe3.XXD");
			Object o = xxdClass.getConstructor().newInstance();
			Method method = xxdClass.getMethod("main", String[].class);

			// Test without arguments

			System.setIn(new InputStream() {
				int index;
				byte[] bytes = input1.getBytes();

				@Override
				public int read() throws IOException {
					if (index < bytes.length)
						return bytes[index++];
					return -1;
				}
			});

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			System.setOut(new PrintStream(bos));

			String[] params = new String[] {};
			method.invoke(o, (Object) params);
			assertEquals(output1, bos.toString());
		} catch (Throwable e) {
			throw e;
		} finally {
			System.setOut(oldOut);
			System.setIn(oldIn);
		}

	}

	@Test
	public void testMainWithOneArgument() throws Throwable {
		PrintStream oldOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		try {
			File f = File.createTempFile("test", "");
			f.deleteOnExit();
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(input1.getBytes());
			fos.close();
			bos.reset();

			Class<?> xxdClass = Class.forName("blatt7.Aufgabe3.XXD");
			Object o = xxdClass.getConstructor().newInstance();
			Method method = xxdClass.getMethod("main", String[].class);

			String[] params = new String[] { f.getPath() };
			method.invoke(o, (Object) params);
			assertEquals(output1, bos.toString());
		} finally {
			System.setOut(oldOut);
		}
	}

	@Test
	public void testMainWithTwoArguments() throws Throwable {

		File f = File.createTempFile("test", "");
		f.deleteOnExit();
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(input1.getBytes());
		fos.close();

		Class<?> xxdClass = Class.forName("blatt7.Aufgabe3.XXD");
		Object o = xxdClass.getConstructor().newInstance();
		Method method = xxdClass.getMethod("main", String[].class);

		// Test with two arguments
		File f2 = File.createTempFile("test", "");
		f2.delete();
		String[] params = new String[] { f.getPath(), f2.getPath() };
		method.invoke(o, (Object) params);
		FileInputStream fin = new FileInputStream(f2);
		assertEquals(output1, new String(fin.readAllBytes()));
		fin.close();
	}

	@Test
	public void testMainWithThreeArguments() throws Throwable {

		Class<?> xxdClass = Class.forName("blatt7.Aufgabe3.XXD");
		Object o = xxdClass.getConstructor().newInstance();
		Method method = xxdClass.getMethod("main", String[].class);
		
		File f = File.createTempFile("test", "");
		f.deleteOnExit();

		// Test with three arguments
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(input2.getBytes());
		fos.close();
		
		
		File f2 = File.createTempFile("test", "");
		f2.delete();
		String[] params = new String[] { f.getPath(), f2.getPath(), "10" };
		method.invoke(o, (Object) params);
		FileInputStream fin = new FileInputStream(f2);
		assertEquals(output2, new String(fin.readAllBytes()));
	}
}
