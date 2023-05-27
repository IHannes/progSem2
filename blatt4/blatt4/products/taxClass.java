package blatt4.products;

public enum taxClass {

FULL(19),REDUCED(7);

	public double taxprice;
	taxClass(double taxprice){
		this.taxprice = taxprice;
	}
	
	public double getPriceWithTax(double amount) {
		return amount+amount/100*taxprice;
	}
}