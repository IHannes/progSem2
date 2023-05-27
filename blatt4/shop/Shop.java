package shop;

public class Shop {
private double availableMoney;
private FulFillmentCenter fulFillmentCenter;

public ShoppingCart newShoppingCart(Customer customer) {
	ShoppingCart cart = new ShoppingCart();
	cart.setCustomer(customer);
	return cart;
}
public void buy(ShoppingCart shoppingCart) throws CannotShipException, NotEnoughMoneyException{
	if(shoppingCart.getCustomer().getAvailableMoney()>=shoppingCart.getGrossPrice()) {
		fulFillmentCenter.sendProductsToCustomer(shoppingCart);
	}else {
		throw new NotEnoughMoneyException();
	}
}
public double getMoney() {
	return availableMoney;
}
public static void main(String[] args) {
	
}
}
