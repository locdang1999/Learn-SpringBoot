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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import danggialoc.springboot.tutorial.datajpa.dto.ItemDTO;
import danggialoc.springboot.tutorial.datajpa.model.Item;
import danggialoc.springboot.tutorial.datajpa.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	@Autowired
	private ItemService service;

	@GetMapping("")
	public ResponseEntity<List<ItemDTO>> getItems() {
		List<Item> items = service.getItems();
		List<ItemDTO> itemdto = items.stream().map(ItemDTO::from).collect(Collectors.toList());
		return new ResponseEntity<>(itemdto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemDTO> getItem(@PathVariable("id") Long id) {
		Item item = service.getItem(id);
		return new ResponseEntity<>(ItemDTO.from(item), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO dto) {
		Item item = service.addItem(Item.from(dto));
		return new ResponseEntity<>(ItemDTO.from(item), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ItemDTO> deleteItem(@PathVariable("id") Long id) {
		Item item = service.delateItem(id);
		return new ResponseEntity<>(ItemDTO.from(item), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemDTO> editItem(@PathVariable("id") Long id, @RequestBody ItemDTO dto) {
		Item item = service.editItem(id,Item.from(dto));
		return new ResponseEntity<>(ItemDTO.from(item), HttpStatus.CREATED);
	}
}
