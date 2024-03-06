package danggialoc.springboot.tutorial.datajpa.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import danggialoc.springboot.tutorial.datajpa.model.Cart;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CartDTO {
	private Long id;
	private String name;
	private List<ItemDTO> itemDto = new ArrayList<>();

	public static CartDTO from(Cart cart) {
		CartDTO dto = new CartDTO();
		dto.setId(cart.getId());
		dto.setName(cart.getName());
		dto.setItemDto(cart.getItems().stream().map(ItemDTO::from).collect(Collectors.toList()));
		return dto;
	}
}
