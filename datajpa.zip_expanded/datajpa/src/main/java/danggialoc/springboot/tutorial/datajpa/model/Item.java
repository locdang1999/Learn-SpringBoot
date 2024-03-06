package danggialoc.springboot.tutorial.datajpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import danggialoc.springboot.tutorial.datajpa.dto.ItemDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String serialNumber;
	
	@ManyToOne
	private Cart cart;

	public static Item from(ItemDTO dto) {
		Item item = new Item();
		item.setSerialNumber(dto.getSerialNumber());
		return item;
	}
}
