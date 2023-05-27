package blatt2;

public class ContainerPerformanceTest {
	public final static int OPERATIONS = 20_000;

	private static void doTestAndMeasure(String message, Runnable r) {
		long startTime = System.currentTimeMillis(); 
		r.run();
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("%40s - Duration: %10d ms", message, endTime - startTime));
	}
	
	private static void testOperations(Container c) {
		Runnable add = () -> { for (int i = 0; i != OPERATIONS; ++i) c.add(i); };
		Runnable removeBack = () -> { for (int i = 0; i != OPERATIONS; ++i) c.remove(i);};
		doTestAndMeasure("Adding elements to container", add);
		doTestAndMeasure("Get size of container", () -> { c.size(); });
		doTestAndMeasure("Removing elements from container", removeBack);
		doTestAndMeasure("Adding elements to container", add);
		doTestAndMeasure("Clearing elements from container", () -> { c.clear(); });	
	}
	
	public static void main(String[] args) {
		Container c = new Vector();
		System.out.println("Testing Vector:");
		System.out.println("---------------");
		testOperations(c);
		
		System.out.println("\n\nTesting List:");
		System.out.println("-------------");
		c = new List();
		testOperations(c);

//		System.out.println("\n\nTesting OptimizedVector:");
//		System.out.println("-------------");
//		c = new OptimizedVector();
//		testOperations(c);
//		
//		System.out.println("\n\nTesting OptimizedList:");
//		System.out.println("-------------");
//		c = new OptimizedList();
//		testOperations(c);
	}
}
