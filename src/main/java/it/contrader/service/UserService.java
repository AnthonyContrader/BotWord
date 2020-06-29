package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;

public class UserService implements Service<UserDTO>{

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public List<UserDTO> getAll() {
		return ConverterUser.toListDTO(userDAO.getAll());
	}

	public boolean insert(UserDTO userDTO) {
		return this.userDAO.insert(ConverterUser.toEntity(userDTO));
	}

	public UserDTO read(int userId) {
		return ConverterUser.toDTO(this.userDAO.read(userId));
	}

	public boolean update(UserDTO userDTO) {
		return this.userDAO.update(ConverterUser.toEntity(userDTO));
	}

	public boolean delete(int userId) {
		return this.userDAO.delete(userId);
	}

// public class UserService extends AbstractService<User, UserDTO> {
//
// 	//Istanzio DAO  e Converter specifici.
// 	public UserService(){
// 		this.dao = new UserDAO();
// 		this.converter = new UserConverter();
// 	}
// }

}
