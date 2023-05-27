package blatt4.products;

public class Price {
private double netPrice;
private taxClass Tax;

public Price(double netPrice, double txClass) {
	this.netPrice = netPrice;
	if(txClass == 19) {
		Tax = taxClass.FULL;
	}
	else if(txClass == 7) {
		Tax = taxClass.REDUCED;
	}
}
public double getNetPrice() {
	return netPrice;
}
public double getGrossPrice() {
	return netPrice+netPrice/100*Tax.taxprice;
}
}