package danggialoc.springboot.tutorial.datajpa.exception;

import java.text.MessageFormat;

public class AlreadyAssignedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlreadyAssignedException(Long itemId, Long cartId) {
		// TODO Auto-generated constructor stub
		super(MessageFormat.format("Item:{0} is already assigned to cart: {1}", itemId, cartId));
	}
}
