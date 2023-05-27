package blatt4.products;

public abstract class AbstractProduct implements Product, Comparable, UnitsSold{
private Price price;
private String name;
	
	@Override
	public Price getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
}
