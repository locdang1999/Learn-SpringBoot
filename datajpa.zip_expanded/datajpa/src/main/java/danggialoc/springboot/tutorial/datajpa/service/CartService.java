package danggialoc.springboot.tutorial.datajpa.service;

import java.util.List;

import danggialoc.springboot.tutorial.datajpa.model.Cart;

public interface CartService {
	Cart addCart(Cart cart);

	List<Cart> getCarts();

	Cart getCart(Long id);

	Cart deleteCart(Long id);

	Cart editCart(Long id, Cart cart);
	
	Cart addItemToCart(Long cartId, Long itemId);
	
	Cart removeItemFromCart(Long cartId, Long itemId);
}
