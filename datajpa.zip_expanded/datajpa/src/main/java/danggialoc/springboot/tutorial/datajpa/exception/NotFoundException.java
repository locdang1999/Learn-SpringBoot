package danggialoc.springboot.tutorial.datajpa.exception;

import java.text.MessageFormat;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String name, Long id) {
		// TODO Auto-generated constructor stub
		super(MessageFormat.format("Could not find " + name + " with id: {0}", id));
	}
}
