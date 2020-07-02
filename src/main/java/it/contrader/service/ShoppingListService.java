package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ShoppingListConverter;
import it.contrader.dao.ShoppingListRepository;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.model.ShoppingList;

@Service
public class ShoppingListService extends AbstractService<ShoppingList, ShoppingListDTO> {

	@Autowired
	private ShoppingListConverter converter;
	@Autowired
	private ShoppingListRepository repository;
}
