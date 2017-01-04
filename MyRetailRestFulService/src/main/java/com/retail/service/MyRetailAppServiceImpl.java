package com.retail.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retail.model.Product;
import com.retail.repository.MyRetailAppRepository;

@Service("myRetailAppService")
public class MyRetailAppServiceImpl implements MyRetailAppService {

	@Autowired
	private MyRetailAppRepository myRetailAppRepository;
	
	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@Override
	public Product getProductDetails(String id) {
		return this.myRetailAppRepository.getProductDetails(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String retrieveProductName(String id) {
		String URL = env.getProperty("external.api.url").concat(id).concat(env.getProperty("external.api.url.params"));
		Map<String, Object> resultMap = this.restTemplate.getForObject(URL, Map.class, new Object[]{id});
		Map<String, Object> productDescriptionMap = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) resultMap.get("product")).get("item")).get("product_description");
		return (String) productDescriptionMap.get("title");
	}
	
	@Override
	public Product getPricingInformation(String id, String name){
		return this.myRetailAppRepository.getPricingInformation(id, name);
	}

	@Override
	public Product updateProductPrice(String id, Double value) {
		return this.myRetailAppRepository.updateProductPrice(id, value);
	}
	
}
