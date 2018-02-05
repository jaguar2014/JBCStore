package com.ashu.demo.repository;

import com.ashu.demo.model.GroceryItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GroceryItemRepo  extends CrudRepository<GroceryItem, Long> {



}