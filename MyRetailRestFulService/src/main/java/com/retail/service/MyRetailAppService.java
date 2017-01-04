package com.retail.service;

import com.retail.model.Product;

public interface MyRetailAppService {
	
	public final String EXTERNAL_URL = "http://redsky.target.com/v1/pdp/tcin/";
	public final String EXTERNAL_URL_PARAM_STRING = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

	public Product getProductDetails(String id);
	public String retrieveProductName(String id);
	public Product getPricingInformation(String id, String name);
	public Product updateProductPrice(String id, Double value);
	
}
