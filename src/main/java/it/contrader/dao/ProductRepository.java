package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Product;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByCategory(String category);

}
