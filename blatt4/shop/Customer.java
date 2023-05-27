package shop;

import blatt4.products.Downloadable;
import blatt4.products.Shippable;

public class Customer {
private String name;
private String address;
private String emailAddress;
private DoubleLinkedList ownedProducts;
private double money;

public void receiveProduct(Shippable product) {
	ownedProducts.add(product);
}

public void downloadProduct(Downloadable product) {
	ownedProducts.add(product);
}
public double getAvailableMoney() {
	return money;
}
public void changeMoney(double amount) {
	this.money-=amount;
}
public Container getProducts() {
	return ownedProducts;
}
}
