package unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import blatt3.Ameise;
import blatt3.Hund;
import blatt3.ZooHabitat;

public class ZooTest {
public ZooHabitat z;


	
	
	@Test
	public void testZooHabitat() {
		z = new ZooHabitat();
		z.setCapacity(50);
		assertEquals(z.getCapacity(), 50);
		try{
		z.addAnimal(new Hund());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		assertTrue(z.getAnimal(0) instanceof Hund);
		assertEquals(z.animals(), 1);
	}
}
