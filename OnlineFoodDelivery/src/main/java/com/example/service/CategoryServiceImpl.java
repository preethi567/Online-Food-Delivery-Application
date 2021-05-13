package com.example.service;


import java.util.List;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Category;
import com.example.exception.CategoryException;
import com.example.exception.ItemException;
import com.example.repository.ICategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
    private ICategoryRepository categoryRepository;
	
	
	@Override
	public Category addCategory(Category cat) throws CategoryException {
		if (cat != null) {
			if (categoryRepository.existsById(cat.getCatId())) {
				throw new CategoryException("Category with this id already exists");
			}
		categoryRepository.save(cat);
		}
		return cat;
	}


	@Override
	public Category updateCategory(Category cat) {
		
		categoryRepository.save(cat);
		return cat;
	}

	@Override
	public String removeCategory(Category cat) {
		
		categoryRepository.deleteById(cat.getCatId());
		String msg="Category removed successfully...";
		return msg;
	}

	@Override
	public Category viewCategoryById(int id) {
		
		Category c=categoryRepository.findByCatId(id);
		return c;
	}

	@Override
	public List<Category> viewAllCategory() {
		
		List<Category> cat=categoryRepository.findAll();
		return cat;
	}

}
