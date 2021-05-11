package com.example.repository;

 


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.entities.Customer;

import com.example.entities.Item;
import com.example.entities.Restaurant;


@Repository
public interface IItemRepository extends JpaRepository<Item, Integer>{


}