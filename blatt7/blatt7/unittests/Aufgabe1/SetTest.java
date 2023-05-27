package blatt7.unittests.Aufgabe1;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Enumeration;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class SetTest {
	private Random random = new Random();
	int first = 1; //random.nextInt();
	int second = 2; //random.nextInt();
	int third = 3; //random.nextInt();
	
	private class ClassInfo {
		Class<?> clazz;
		Object instance;
		Method elements;
		Method add;
		
		public ClassInfo(Class<?> clazz, Object instance, Method elements, Method add) {
			this.clazz = clazz;
			this.instance = instance;
			this.elements = elements;
			this.add = add;
		}
	}
	
	protected void testMethod(Class<?> clazz, String methodName, Class<?> returnType, Class<?>...parameters) throws NoSuchMethodException, SecurityException {
		Method method = clazz.getMethod(methodName, parameters);
		assertEquals(returnType, method.getReturnType());
		int objectCount = 0;
		for (Class<?> parameter: parameters)
			if (parameter == Object.class)
				objectCount++;
		assertEquals(objectCount, method.getGenericParameterTypes().length);
	}
	
	@Test
	public void testClasses() throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> setClass = Class.forName("blatt7.Aufgabe1.Set");
		assertTrue(setClass.isInterface());
		assertEquals(1, setClass.getTypeParameters().length);
		testMethod(setClass, "add", boolean.class, Object.class);
		testMethod(setClass, "test", boolean.class, Object.class);
		testMethod(setClass, "remove", boolean.class, Object.class);
		testMethod(setClass, "elements", Enumeration.class);
		
		Class<?> abstractSetClass = Class.forName("blatt7.Aufgabe1.AbstractSet");
		assertTrue(Modifier.isAbstract(abstractSetClass.getModifiers()));
		Class<?> normalSetClass = Class.forName("blatt7.Aufgabe1.NormalSet");
		Object normalSet = normalSetClass.getConstructor().newInstance();
		Class<?> orderedSetClass = Class.forName("blatt7.Aufgabe1.OrderedSet");
		Object orderedSet = orderedSetClass.getConstructor().newInstance();
		
		Method method = normalSetClass.getMethod("elements");
		Object enumeration = method.invoke(normalSet);
		assertTrue(enumeration.getClass().isAnonymousClass());
		
		method = orderedSetClass.getMethod("elements");
		enumeration = method.invoke(orderedSet);
		assertTrue(enumeration.getClass().isAnonymousClass());
	}
	
	private ClassInfo testSetBasics(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> setClass = Class.forName(className);
		Object set = setClass.getConstructor().newInstance();
		Method add = setClass.getMethod("add", Object.class);
		Method remove = setClass.getMethod("remove", Object.class);
		Method test = setClass.getMethod("test", Object.class);
		Method elements = setClass.getMethod("elements");

		assertFalse((boolean)test.invoke(set, first));
		assertTrue((boolean)add.invoke(set, first));
		assertTrue((boolean)test.invoke(set, first));

		assertFalse((boolean)test.invoke(set, second));
		assertTrue((boolean)add.invoke(set, second));
		assertTrue((boolean)test.invoke(set, second));
		
		assertFalse((boolean)test.invoke(set, third));
		assertTrue((boolean)add.invoke(set, third));
		assertTrue((boolean)test.invoke(set, third));
		
		assertFalse((boolean)add.invoke(set, first));
		assertFalse((boolean)add.invoke(set, second));
		assertFalse((boolean)add.invoke(set, third));
		
		assertTrue((boolean)remove.invoke(set, first));
		assertFalse((boolean)test.invoke(set, first));

		assertTrue((boolean)remove.invoke(set, second));
		assertFalse((boolean)test.invoke(set, second));
		
		assertTrue((boolean)remove.invoke(set, third));
		assertFalse((boolean)test.invoke(set, third));
		
		assertTrue((boolean)add.invoke(set, first));
		assertTrue((boolean)add.invoke(set, second));
		assertTrue((boolean)add.invoke(set, third));

		return new ClassInfo(setClass, set, elements, add);
	}

	@Test
	public void testNormalSet() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ClassInfo classInfo = testSetBasics("blatt7.Aufgabe1.NormalSet");
		
		Enumeration<?> enumeration = (Enumeration<?>)classInfo.elements.invoke(classInfo.instance);
		assertTrue(enumeration.hasMoreElements());
		assertEquals(first, enumeration.nextElement());
		assertTrue(enumeration.hasMoreElements());
		assertEquals(second, enumeration.nextElement());
		assertTrue(enumeration.hasMoreElements());
		assertEquals(third, enumeration.nextElement());
		assertFalse(enumeration.hasMoreElements());
	}

	@Test
	public void testOrderedSet() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ClassInfo classInfo = testSetBasics("blatt7.Aufgabe1.OrderedSet");
		Object o = classInfo.clazz.getConstructor().newInstance();
		try {
			classInfo.add.invoke(o, new Object());
			fail("Ordered Set allows to add objects that are not comparable!");
		} catch (Throwable e) {}
		Enumeration<?> enumeration = (Enumeration<?>)classInfo.elements.invoke(classInfo.instance);

		// add a couple of more elements into the set
		for (int i = 0; i != 20; ++i) {
			classInfo.add.invoke(classInfo.instance, random.nextInt(Integer.MAX_VALUE));
		}
		// ensure that all elements inside the set are sorted ascending
		int lastValue = -1; 
		while (enumeration.hasMoreElements()) {
			int value = (int) enumeration.nextElement();
			assertTrue( lastValue < value);
			lastValue = value;
		}
	}
}
