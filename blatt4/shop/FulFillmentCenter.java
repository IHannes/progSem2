package shop;

import blatt4.products.Downloadable;
import blatt4.products.Shippable;

public class FulFillmentCenter {

public void sendProductsToCustomer(ShoppingCart shoppingCart) throws CannotShipException{
	Customer customer = shoppingCart.getCustomer();
	for(int i = 0; i<shoppingCart.getProducts().size(); i++) {
		if(shoppingCart.getProducts().get(i) instanceof Shippable) {
			Shippable s =(Shippable) shoppingCart.getProducts().get(i);
			customer.receiveProduct(s);
		}
		else if(shoppingCart.getProducts().get(i) instanceof Downloadable) {
			Downloadable s =(Downloadable) shoppingCart.getProducts().get(i);
			customer.downloadProduct(s);
		}
		else {
			throw new CannotShipException();
		}
	}
	shoppingCart.getProducts().clear();
}
}
