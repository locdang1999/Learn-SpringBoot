package danggialoc.springboot.tutorial.datajpa.dto;

import java.util.Objects;

import danggialoc.springboot.tutorial.datajpa.model.Item;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemDTO {
	private Long id;
	private String serialNumber;
	private PlainCartDto plainCartDto;

	public static ItemDTO from(Item item) {
		ItemDTO itemDto = new ItemDTO();
		itemDto.setId(item.getId());
		itemDto.setSerialNumber(item.getSerialNumber());
		if (Objects.nonNull(item.getCart())) {
			itemDto.setPlainCartDto(PlainCartDto.from(item.getCart()));
		}
		return itemDto;
	}
}
