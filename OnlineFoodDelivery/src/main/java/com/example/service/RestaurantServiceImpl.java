package com.example.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Restaurant;
import com.example.exception.RestaurantException;
import com.example.repository.IRestaurantRepository;



@Service
@Transactional
public  class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	private IRestaurantRepository restaurantRepository;
	
	/*@Autowired
	IItemRepository repo2;*/
	
	
	
	@Override
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException {
		if (res != null) {
			if (restaurantRepository.existsById(res.getRestaurantId())) {
				throw new RestaurantException("Restaurant with this id already exists");
			}
			restaurantRepository.save(res);
		}

		return res;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		
		restaurantRepository.saveAndFlush(restaurant);
		return restaurant;
	}
	@Override
	public String removeRestaurantById(int Rid) {
		
		Restaurant rest=restaurantRepository.findByRestaurantId(Rid);
//		List<Item> list=repo2.findItemsByRestaurant(rest.getRestaurantName());
//		for(int i=0;i<list.size();i++)
//		{
//			Item item=list.get(i);
//			int id=item.getItemId();
//			repo2.deleteById(id);
//		}
		restaurantRepository.deleteById(Rid);
		
		String msg="Remove restaurant successfull !!!";
		return msg;
	}
 
	
	

	@Override
	public List<Restaurant> viewAllRestaurants() {
		
		List<Restaurant> list=restaurantRepository.findAll();
		return list;
	}
	
	@Override
	public Restaurant viewRestaurantById(int id) {
		
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		return restaurant;	
	}


	@Override
	public List<Restaurant> viewNearByRestaurant(String location) {
		
		List<Restaurant> list = restaurantRepository.viewNearByRestaurant(location);
		return list;
	}


	@Override
	public List<Restaurant> viewRestaurantByItemName(String restaurantName) {
		
		//List<Restaurant> list=repository.viewRestaurantByItemName(restaurantName);
		List<Restaurant> list=restaurantRepository.findByRestaurantName(restaurantName);
		return list;
	}
}