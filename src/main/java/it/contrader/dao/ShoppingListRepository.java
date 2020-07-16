package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.ShoppingList;

@Repository
@Transactional
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
	
	List<ShoppingList> findByUserId(Long userId);
}
