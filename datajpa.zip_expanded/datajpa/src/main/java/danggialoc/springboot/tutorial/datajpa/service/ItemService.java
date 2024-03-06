package danggialoc.springboot.tutorial.datajpa.service;

import java.util.List;

import danggialoc.springboot.tutorial.datajpa.model.Item;

public interface ItemService {
	Item addItem(Item item);

	List<Item> getItems();

	Item getItem(Long id);

	Item delateItem(Long id);

	Item editItem(Long id, Item item);
}
