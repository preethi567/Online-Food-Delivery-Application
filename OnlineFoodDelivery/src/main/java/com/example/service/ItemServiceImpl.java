package com.example.service;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Item;
import com.example.entities.Restaurant;
import com.example.exception.ItemException;
import com.example.repository.IItemRepository;



@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private IItemRepository itemRepository;
	@PersistenceContext
	EntityManager em ;
	@Override
	public Item addItem(Item item) throws ItemException {
		// TODO Auto-generated method stub
		if (item != null) {
			if (itemRepository.existsById(item.getItemId())) {
				throw new ItemException("Item with this id already exists");
			}
		itemRepository.save(item);
		}
		return item;
	}

	@Override
	public Item viewItem(int id) {
		// TODO Auto-generated method stub
		Optional<Item> item =itemRepository.findById(id); 
		return item.get();
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		itemRepository.saveAndFlush(item);
		return item;

	}

	@Override
	public void removeItem(int itemId) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(itemId);
		
		
		
	}

	

	@Override
	public List<Item> findItemsByRestaurant(String name) {
		
		
		List<Item> list=itemRepository.findItemsByRestaurant(name);
		return list;		
	}

	@Override
	public List<Item> viewAllItemsByCategory(String name) {
		
	
		List<Item> list=itemRepository.findItemsByCategory(name);
		return list;
		
	}

	@Override
	public List<Item> viewAllItemsByName(String name) {
		
		
		List<Item> list=itemRepository.findItemsByItemName(name);
		return list;
	}
}