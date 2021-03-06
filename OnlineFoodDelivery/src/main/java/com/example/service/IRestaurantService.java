package com.example.service;

import java.util.List;

import com.example.entities.Restaurant;
import com.example.exception.RestaurantException;



public interface IRestaurantService {

	public Restaurant addRestaurant(Restaurant res) throws RestaurantException;
	public Restaurant updateRestaurant(Restaurant res);
	public String removeRestaurantById(int id);
	public Restaurant viewRestaurantById(int id);
	public List<Restaurant> viewAllRestaurants();
	public List<Restaurant> viewNearByRestaurant(String location);
	public List<Restaurant> viewRestaurantByItemName(String name);

}
