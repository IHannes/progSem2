package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import blatt3.Container;
import blatt3.DoubleLinkedList;
import blatt3.Vector;

public class TestContainer {
	Container container;
	
	@Test
	public void test() {
		container = new DoubleLinkedList();
		assertEquals(0, container.size());
		container.add("Test String");
		container.add("Zweiter Test String");
		container.add("Dritter Test String");
		assertEquals(3, container.size());
		assertFalse(container.isEmpty());
		assertFalse(container.contains("Nicht im Container"));
		assertTrue(container.contains("Test String"));
		assertEquals(container.toArray().length , 3);
		container.remove("Zweiter Test String");
		assertEquals(2, container.size());
		assertEquals(container.toArray().length, 2);
		container.clear();
		assertEquals(0, container.size());
	}
}
