package com.example.service;

import java.util.List;

import com.example.entities.Item;
import com.example.entities.Restaurant;


public interface IItemService {

	public Item addItem(Item item);
	public Item viewItem(int id);
	public Item updateItem(Item item);
	public void removeItem(int itemId);
	public List<Item> viewAllItems(int catId);
	public List<Item> viewAllItemsByName(String name);
}