package danggialoc.springboot.tutorial.datajpa.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import danggialoc.springboot.tutorial.datajpa.exception.AlreadyAssignedException;
import danggialoc.springboot.tutorial.datajpa.exception.NotFoundException;
import danggialoc.springboot.tutorial.datajpa.model.Cart;
import danggialoc.springboot.tutorial.datajpa.model.Item;
import danggialoc.springboot.tutorial.datajpa.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemService itemService;

	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getCarts() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(cartRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Cart getCart(Long id) {
		// TODO Auto-generated method stub
		return cartRepository.findById(id).orElseThrow(() -> new NotFoundException("cart", id));
	}

	@Override
	public Cart deleteCart(Long id) {
		// TODO Auto-generated method stub
		Cart cart = getCart(id);
		cartRepository.delete(cart);
		return cart;
	}

	@Override
	@Transactional
	public Cart editCart(Long id, Cart cart) {
		// TODO Auto-generated method stub
		Cart cartToEdit = getCart(id);
		cartToEdit.setName(cart.getName());
		return cartToEdit;
	}

	@Override
	@Transactional
	public Cart addItemToCart(Long cartId, Long itemId) {
		// TODO Auto-generated method stub
		Cart cart = getCart(cartId);
		Item item = itemService.getItem(itemId);
		if(Objects.nonNull(item.getCart())) {
			throw new AlreadyAssignedException(itemId, item.getCart().getId());
		}
		cart.addItem(item);
		item.setCart(cart);
		return cart;
	}

	@Override
	@Transactional
	public Cart removeItemFromCart(Long cartId, Long itemId) {
		// TODO Auto-generated method stub
		Cart cart = getCart(cartId);
		Item item = itemService.getItem(itemId);
		cart.removeItem(item);
		return cart;
	}

}
