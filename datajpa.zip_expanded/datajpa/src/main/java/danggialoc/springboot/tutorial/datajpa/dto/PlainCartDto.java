package danggialoc.springboot.tutorial.datajpa.dto;

import danggialoc.springboot.tutorial.datajpa.model.Cart;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PlainCartDto {
	private Long id;
	private String name;

	public static PlainCartDto from(Cart cart) {
		PlainCartDto plainCartDto = new PlainCartDto();
		plainCartDto.setId(cart.getId());
		plainCartDto.setName(cart.getName());
		return plainCartDto;
		
	}
}
