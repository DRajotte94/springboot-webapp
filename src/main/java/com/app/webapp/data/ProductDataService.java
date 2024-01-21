package com.app.webapp.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.app.webapp.model.ProductModel;
import com.app.webapp.model.ProductsMapper;

@Repository
@Primary
public class ProductDataService implements ProductsDataAccessInterface {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductModel> getProducts() {
		List<ProductModel> results = jdbcTemplate.query("SELECT * FROM products", new ProductsMapper());
		return results;
	}
	
	@Override
	public ProductModel getById(int id) {
		List<ProductModel> results = jdbcTemplate.query("SELECT * FROM products WHERE product_num = ?", new ProductsMapper(), id);
		
		if (results.size() > 0) {
			return results.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<ProductModel> searchProducts(String searchTerm) {
		List<ProductModel> results = jdbcTemplate.query("SELECT * FROM products WHERE name LIKE ?", new ProductsMapper(), "%" + searchTerm + "%");
		return results;
	}

	@Override
	public long addProduct(ProductModel newProduct) {
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleInsert.withTableName("products").usingGeneratedKeyColumns("product_num");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("type", newProduct.getType());
		parameters.put("name", newProduct.getName());
		parameters.put("description", newProduct.getDescription());
		parameters.put("price", newProduct.getPrice());
		
		Number result = simpleInsert.executeAndReturnKey(parameters);
		
		return result.longValue();
	}
	
	@Override
	public ProductModel updateProduct(ProductModel updateProduct) {
		int result = jdbcTemplate.update("UPDATE products SET type = ?, name = ?, description = ?, price = ? WHERE product_num = ?", 
				updateProduct.getType(),
				updateProduct.getName(),
				updateProduct.getDescription(),
				updateProduct.getPrice(),
				updateProduct.getProductNumber()
			);
//		if (result > 0) {
//			return updateProduct;
//		} else {
//			return null;
//		}
		return updateProduct;
	}

	@Override
	public boolean deleteProduct(int id) {
		int result = jdbcTemplate.update("DELETE FROM products WHERE product_num = ?", id);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

}
