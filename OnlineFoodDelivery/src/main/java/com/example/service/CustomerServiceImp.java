package com.example.service;



import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Customer;
import com.example.entities.FoodCart;
import com.example.repository.ICartRepository;
import com.example.repository.ICustomerRepository;


@Service
@Transactional
public class CustomerServiceImp implements ICustomerService{

	@Autowired
	ICustomerRepository repository;
	
	@Autowired
	ICartRepository cartRepository;
	
	
	@Override
	public Customer addCustomer(Customer customer)  {
		
		repository.save(customer);
		FoodCart cart= new FoodCart();
		cart.setCustomer(customer);
		cartRepository.save(cart);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		repository.save(customer);
		return customer;
	}

	@Override
	public String removeCustomerById(int id) {
	
		int cartId=cartRepository.findcartByCustomerId(id);
		cartRepository.deleteById(cartId);
		repository.deleteById(id);
		String msg="Customer Removed successfully...";
		return msg;
	}

	@Override
	public Customer viewCustomerById(int id) {
		
		Customer customer=repository.findById(id).orElse(null);
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer(String restaurantName) {
		
		List<Customer> list=repository.findByRestaurantName(restaurantName);
		return list;
	}


}
