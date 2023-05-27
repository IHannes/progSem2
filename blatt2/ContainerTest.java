package blatt2;

public class ContainerTest {
	public static void testContainer(Container container) {
		System.out.println("Testing the container ...");

		// Wir fügen drei Elemente in den Container ein
		System.out.println("Rufe methode isEmpty() auf leeren Container auf. Resultat: " + container.isEmpty());

		System.out.println("Anzahl Elemente im Container: " + container.size());
		container.add("Test String");
		container.add("Zweiter Test String");
		container.add("Dritter Test String");
		System.out.println("Anzahl Elemente im Container nachdem drei Elemente eingefügt wurden: " + container.size());

		System.out.println(
				"Rufe Methode isEmpty() auf container mit drei Elementen auf. Resultat: " + container.isEmpty());

		System.out.println("Rufe Methode contains() auf (Objekt ist nicht im Container). Resultat: "
				+ container.contains("Nicht im Container"));
		System.out.println("Rufe Methode contains() auf (Objekt ist im Container). Resultat: "
				+ container.contains("Zweiter Test String"));

		System.out.println("Prüfe ob alle drei Elemente mit toArray() zurück gegeben werden");
		Object[] array = container.toArray();
		for (int i = 0; i != array.length; ++i) {
			System.out.println(array[i]);
		}

		System.out.println("Lösche Element \"Zweiter Test String\" aus container ...");
		container.remove("Zweiter Test String");
		System.out.println("Anzahl von Elementen nach Löschen im Container: " + container.size());

		System.out.println("Prüfe ob die verbleibenden zwei Elemente mit toArray() zurück gegeben werden");
		array = container.toArray();
		for (int i = 0; i != array.length; ++i) {
			System.out.println(array[i]);
		}

		System.out.println("Anzahl Elemente im Container vor Aufruf von clear(): " + container.size());
		container.clear();
		System.out.println("Anzahl Element im Container nach Aufruf von clear(): " + container.size());
	}
	
	public static void testContainerEqualsToString(Container c1, Container c2) {
		System.out.println("Container1: ");
		System.out.println(c1);
		System.out.println("Container2: ");
		System.out.println(c2);
		System.out.println("Vergleiche Container mit equals: " + c1.equals(c2));
	}

	public static void main(String[] args) {
		Container container;
		//container = new DummyContainer();
		//container = new Vector();
		container = new List();
		testContainer(container);
		
		//TODO: Uncomment to test equals and toString in AbstractContainer 
		List l1 = new List();
		List l2 = new List();
		l1.add("Test1"); l2.add("Test2");
		l1.add("Test2"); l2.add("Test2");
		testContainerEqualsToString(l1, l2);
	}
}
