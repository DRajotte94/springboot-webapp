package com.app.webapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductModel product = new ProductModel(
				rs.getInt("product_num"), 
				rs.getString("type"),
				rs.getString("name"), 
				rs.getString("description"), 
				rs.getDouble("price")
			);
		
		return product;
	}

}
