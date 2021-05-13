package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.entities.Address;
import com.example.entities.Item;
import com.example.entities.Restaurant;
import com.example.exception.RestaurantException;
import com.example.repository.IRestaurantRepository;


	@SpringBootTest
	public class RestaurantServiceTest {
	@Autowired
	private RestaurantServiceImpl resService;

	 @MockBean
	private IRestaurantRepository resRepo;
	 Restaurant re=new Restaurant();
	 List<Item> listItem = re.getItemList();
	@Test
	public void saveRestaurantTest() throws RestaurantException {
		Restaurant r=new Restaurant(1,"Srikanya",new Address(1,"house","devichowk","511","rjy","ap","india","533106"),listItem,"Agarwal","9876543210");
		when(resRepo.save(r)).thenReturn(r);
	//Product p2=new Product(29,"HD",45,900000,null);
	
	assertEquals(r,resService.addRestaurant(r));
	}
	@Test
	public void deleteRestaurantTest() {
		Restaurant r=new Restaurant(1,"Srikanya",new Address(1,"house","devichowk","511","rjy","ap","india","533106"),listItem,"Agarwal","9876543210");
	resService.removeRestaurantById(25);
	verify(resRepo,times(1)).deleteById(25);
	

	}
	}
