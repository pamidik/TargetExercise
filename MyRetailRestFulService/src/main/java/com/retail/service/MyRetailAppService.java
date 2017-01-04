package com.retail.service;

import com.retail.model.Product;

public interface MyRetailAppService {
	
	public Product getProductDetails(String id);
	public String retrieveProductName(String id);
	public Product getPricingInformation(String id, String name);
	public Product updateProductPrice(String id, Double value);
	
}
