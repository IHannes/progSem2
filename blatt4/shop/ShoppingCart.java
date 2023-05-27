package shop;

import blatt4.products.Product;

public class ShoppingCart {
private DoubleLinkedList products;
private Customer customer;

public void addProduct(Product product) {
	products.add(product);
}
public double getGrossPrice(){
	double d = 0;
	for(int i = 0; i<products.size(); i++) {
		if(products.get(i) instanceof Product) {
			Product p =(Product) products.get(i);
			d+=p.getPrice().getGrossPrice();
		}
	}
	return d;
	}

public Container getProducts() {
	return products;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
}