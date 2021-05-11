package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Category;


public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
