package com.retail.repository;

import com.retail.model.Product;

public interface MyRetailAppRepository {
	
	public final String PRODUCT_DETAILS_QUERY = "SELECT * FROM TargetExercise.Products WHERE id=?";
	public final String PRICE_DETAILS_QUERY = "SELECT * FROM TargetExercise.Products WHERE id=? AND name=?";
	public final String UPDATE_PRODUCT_PRICE_QUERY = "UPDATE TargetExercise.Products SET value=? WHERE id=?";
	
	public Product getProductDetails(String id);
	public Product getPricingInformation(String id, String name);
	public Product updateProductPrice(String id, Double value);
	
}
