package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.ShoppingList;

@Repository
@Transactional
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
}
