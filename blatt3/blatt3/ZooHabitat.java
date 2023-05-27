package blatt3;

public class ZooHabitat{
	private DoubleLinkedList animals = new DoubleLinkedList();
	private int maxCapacity;
	
	public void addAnimal(Object o) throws InvalidAnimalException, HabitatFullException{
		if(animals.getFirst()==null) {
			animals.add(o);
		}
		Object obj = animals.getFirst();
		if(!((obj instanceof Herbivore && o instanceof Herbivore) || (obj instanceof Carnivore && o instanceof Carnivore) || (obj instanceof Omnivore && o instanceof Omnivore))) {
			throw new InvalidAnimalException();
		}
		else if(animals.size()>=maxCapacity) {
			throw new HabitatFullException();
		}
		animals.add(o);
	}
	
	public int animals(){
		return animals.size();
	}
	
	public int getCapacity() {
		return maxCapacity;
	}
	
	public void setCapacity(int capacity) {
		this.maxCapacity = capacity;
	}
	
	public Animal getAnimal(int index) {
		if(animals.get(index) instanceof Animal) {
			return (Animal) animals.get(index);
		}
		return null;
	}
}
