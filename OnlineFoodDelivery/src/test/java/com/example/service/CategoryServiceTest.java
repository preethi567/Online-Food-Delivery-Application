package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.entities.Category;
import com.example.exception.CategoryException;
import com.example.repository.ICategoryRepository;

@SpringBootTest
public class CategoryServiceTest {
	@Autowired
	private CategoryServiceImpl catService;

	 @MockBean
	private ICategoryRepository catRepo;
	@Test
	public void saveCategoryTest() throws CategoryException {
		Category c=new Category(1,"non-veg");
	//Category c2=new Product(29,"HD",45,900000,null);
	when(catRepo.save(c)).thenReturn(c);
	assertEquals(c,catService.addCategory(c));
	}
	@Test
	public void deleteCategoryTest() throws CategoryException{
		Category c=new Category(1,"non-veg");
	catService.removeCategory(c);
	verify(catRepo,times(1)).deleteById(1);
	}
	
	@Test
	public void viewCategoryById() {
		Category c=new Category(1,"non-veg");
		//Category c=catRepo.findById(10).orElse(null);
		when(catRepo.findByCatId(1)).thenReturn(c);
		Category result = catService.viewCategoryById(c.getCatId());
		
		assertEquals(result.getCatId(),c.getCatId());
	}
	}

