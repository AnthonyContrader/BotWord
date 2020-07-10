package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.ShoppingListRepository;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.model.ShoppingList;

@Service
public class ShoppingListService extends AbstractService<ShoppingList, ShoppingListDTO> {
	
	public List<ShoppingListDTO> findByUserId(Long userId){
		
		return converter.toDTOList(((ShoppingListRepository) repository).findByUserId(userId));
	}

}
