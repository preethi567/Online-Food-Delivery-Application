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
import com.example.entities.Category;
import com.example.entities.Item;
import com.example.entities.Restaurant;
import com.example.exception.ItemException;
import com.example.repository.IItemRepository;
@SpringBootTest
public class ItemServiceTest {

		@Autowired
	private ItemServiceImpl itemService;

	 @MockBean
	private IItemRepository itemRepo;
	 Restaurant re=new Restaurant();
	 List<Item> listItem = re.getItemList();
	@Test
	public void saveItemTest() throws ItemException {
		Category c=new Category(1,"non-veg");
		Restaurant r=new Restaurant(1,"Srikanya",new Address(1,"house","devichowk","511","rjy","ap","india","533106"),listItem,"Agarwal","9876543210");
	Item p=new Item(27,"CHICKENBIRYANI",c, 2,1500,r);
	//Item p2=new Product(29,"HD",45,900000,null);
	when(itemRepo.save(p)).thenReturn(p);
	assertEquals(p,itemService.addItem(p));
	}
	@Test
	public void deleteItemTest() {
		Category c=new Category(1,"non-veg");
		Restaurant r=new Restaurant(1,"Srikanya",new Address(1,"house","devichowk","511","rjy","ap","india","533106"),listItem,"Agarwal","9876543210");
	Item p=new Item(25,"CHICKENBIRYANI",c, 2,1500,r);
		itemService.removeItem(25);
	verify(itemRepo,times(1)).deleteById(25);
	}

	}

