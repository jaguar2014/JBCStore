package com.ashu.demo.repository;

import com.ashu.demo.model.CleaningItems;
import org.springframework.data.repository.CrudRepository;

public interface CleaningItemsRepository extends CrudRepository<CleaningItems,Long> {
}
