package danggialoc.springboot.tutorial.datajpa.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import danggialoc.springboot.tutorial.datajpa.exception.NotFoundException;
import danggialoc.springboot.tutorial.datajpa.model.Item;
import danggialoc.springboot.tutorial.datajpa.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository repository;

	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		return repository.save(item);
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Item getItem(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(() -> new NotFoundException("item",id));
	}

	@Override
	public Item delateItem(Long id) {
		// TODO Auto-generated method stub
		Item item = getItem(id);
		repository.delete(item);
		return item;
	}

	@Override
	@Transactional
	public Item editItem(Long id, Item item) {
		// TODO Auto-generated method stub
		Item itemToEdit = getItem(id);
		itemToEdit.setSerialNumber(item.getSerialNumber());
		return itemToEdit;
	}

}
