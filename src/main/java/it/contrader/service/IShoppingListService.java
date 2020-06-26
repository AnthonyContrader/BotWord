package it.contrader.service;

public interface IShoppingListService<DTO> extends Service<DTO> {
	
	public DTO findByUserId(int userId);

}
