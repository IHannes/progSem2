package unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import blatt4.products.Book;
import blatt4.products.Computer;
import blatt4.products.Game;
import blatt4.products.Monitor;

public class productTest {
	private Computer c;
	private Book b;
	private Monitor m;
	private Game g;
	
	public void initialize() {
		c = new Computer(12,34,23,1);
		b = new Book(12,2,24,5,3);
		m = new Monitor(23,1,3,4);
		g = new Game(1343);
	}
	
	@Test
	public void testComputerGet() {
		initialize();
		assertEquals(12, c.getWeight());
		assertEquals(34, c.getHeight());
		assertEquals(23, c.getWidth());
		assertEquals(1, c.getLength());
	}
	
	@Test
	public void testComputerUnitsSols() {
		del();
		initialize();
		c.unitSold();
		c.unitSold();
		assertEquals(2, c.getUnitsSold());
	}
	
	private void del() {
		File myObj = new File("/home/hanhil/eclipse-workspace/blatt4prog2/computer.txt"); 
	    if (myObj.delete()) { 
	      System.out.println("Deleted the file: " + myObj.getName());
	    } else {
	      System.out.println("Failed to delete the file.");
	    } 
	}
}
