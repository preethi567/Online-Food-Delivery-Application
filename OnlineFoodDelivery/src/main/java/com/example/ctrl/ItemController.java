package com.example.ctrl;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Item;
import com.example.exception.ItemException;
import com.example.service.IItemService;



@RestController
@CrossOrigin
@RequestMapping(path="item")
public class ItemController {
	@Autowired
	private IItemService itemService;

		@PostMapping("/addItem")
		public Item AddItem(@RequestBody Item item) throws ItemException{
			return itemService.addItem(item);
		}
		@GetMapping("/{itemId}")
		public ResponseEntity<Item> findItem(@PathVariable("itemId")int itemId){
			Item items= itemService.viewItem(itemId);
			if(items==null) {
				return new ResponseEntity("Sorry! Items not found!", HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Item>(items, HttpStatus.OK);
		}
		@PutMapping("/updateItem")
		public ResponseEntity<Item> updateItem(@Valid @RequestBody Item item) {
			
			Item item1 = itemService.viewItem(item.getItemId());
			
				Item item2 = itemService.updateItem(item);
				return new ResponseEntity<Item>(item2, HttpStatus.OK);
			
		}
		@DeleteMapping("/deleteItem/{itemId}")
		public ResponseEntity<?> deleteItem(@PathVariable("itemId")int itemId){
			itemService.removeItem(itemId);
			
			return new ResponseEntity<>("Item deleted", HttpStatus.OK);
		}
		@GetMapping("/viewAllItemsByCategory/{categoryName}")
		public ResponseEntity<List<Item>> viewAllItemsByCategory(@PathVariable("categoryName") String name)
			 {

			
			List<Item> item2 = itemService.viewAllItemsByCategory(name);
			if (item2.isEmpty()) {
				return new ResponseEntity("Sorry! Items not found!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Item>>(item2, HttpStatus.OK);
		}

		@GetMapping("/viewAllItemsByItemName/{itemName}")
		public ResponseEntity<List<Item>> viewAllItemsByItemName(@PathVariable("itemName") String name)
  {
			
			
			List<Item> items = itemService.viewAllItemsByName(name);
			if (items.isEmpty()) {
				return new ResponseEntity("Sorry! Items not found!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
		}

		@GetMapping("/findItemsByRestaurant/{restaurantName}")
		public ResponseEntity<List<Item>> findItemsByRestaurant(@PathVariable("restaurantName") String name)
				 {
			
			List<Item> items = itemService.findItemsByRestaurant(name);
			if (items.isEmpty()) {
				return new ResponseEntity("Sorry! Items not found!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
		}

	}