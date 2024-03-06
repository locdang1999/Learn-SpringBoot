package danggialoc.learn.springaopdemo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	
	public void checkout(String status) {
		//Bussiness logic
		// Logging
		//Authentication & Authorization
		//Sanitize the data
		
		System.out.println("Checkout Method from Shopping Cart Called");
	}

	public int quantity() {
		return 2;
	}
	
}
