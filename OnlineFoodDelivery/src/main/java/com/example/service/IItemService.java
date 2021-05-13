package com.example.service;

import java.util.List;

import com.example.entities.Item;
import com.example.entities.Restaurant;
import com.example.exception.ItemException;


public interface IItemService {

	public Item addItem(Item item) throws ItemException;
	public Item viewItem(int id);
	public Item updateItem(Item item);
	public void removeItem(int itemId);
	public List<Item> viewAllItemsByCategory(String name);
	public List<Item> findItemsByRestaurant(String name);
	public List<Item> viewAllItemsByName(String name);
}