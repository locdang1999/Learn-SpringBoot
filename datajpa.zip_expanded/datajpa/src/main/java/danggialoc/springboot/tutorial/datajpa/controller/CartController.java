package danggialoc.springboot.tutorial.datajpa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import danggialoc.springboot.tutorial.datajpa.dto.CartDTO;
import danggialoc.springboot.tutorial.datajpa.model.Cart;
import danggialoc.springboot.tutorial.datajpa.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService service;

	@GetMapping("")
	public ResponseEntity<List<CartDTO>> getCarts() {
		List<Cart> carts = service.getCarts();
		List<CartDTO> dto = carts.stream().map(CartDTO::from).collect(Collectors.toList());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<CartDTO> getCart(@PathVariable("id") Long id) {
		Cart cart = service.getCart(id);
		return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<CartDTO> addCart(@RequestBody CartDTO dto) {
		Cart cart = service.addCart(Cart.from(dto));
		return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<CartDTO> deletCart(@PathVariable("id") Long id) {
		Cart cart = service.deleteCart(id);
		return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
	}

	@PostMapping("{id}")
	public ResponseEntity<CartDTO> editCart(@PathVariable("id") Long id, @RequestBody CartDTO dto) {
		Cart cart = service.editCart(id, Cart.from(dto));
		return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
	}

	@PostMapping("/{cartId}/items/{itemId}/add")
	public ResponseEntity<CartDTO> addItemToCart(@PathVariable("cartId") Long cartId,
			@PathVariable("itemId") Long itemId) {
		Cart cart = service.addItemToCart(cartId, itemId);
		return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
	}

	@DeleteMapping("/{cartId}/items/{itemId}/delete")
	public ResponseEntity<CartDTO> removeItemFromCart(@PathVariable("cartId") Long cartId,
			@PathVariable("itemId") Long itemId) {
		Cart cart = service.removeItemFromCart(cartId, itemId);
		return new ResponseEntity<>(CartDTO.from(cart), HttpStatus.OK);
	}
}
