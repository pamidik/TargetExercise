package com.retail.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.retail.model.PriceDetail;
import com.retail.model.Product;
import com.retail.repository.MyRetailAppRepository;

public class MyRetailAppServiceImplTest {
	
	private MyRetailAppServiceImpl myRetailAppServiceImpl;
	
	@Mock
	private MyRetailAppRepository myRetailAppRepository;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Before
	public void setUp() throws Exception {
		myRetailAppServiceImpl = new MyRetailAppServiceImpl();
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(myRetailAppServiceImpl, "myRetailAppRepository", myRetailAppRepository);
		ReflectionTestUtils.setField(myRetailAppServiceImpl, "restTemplate", restTemplate);
	}
	
	@Test
	public void testGetProductDetails(){
		String id="15117729";
		
		Product expectedProduct = new Product();
		expectedProduct.setId(id);
		expectedProduct.setName("Apple iPhone 7 128GB");
		PriceDetail expectedPriceDetail = new PriceDetail();
		expectedPriceDetail.setCurrency_code("USD");
		expectedPriceDetail.setValue(499.99);
		expectedProduct.setCurrent_price(expectedPriceDetail);
		Mockito.when(this.myRetailAppRepository.getProductDetails(Mockito.anyString())).thenReturn(expectedProduct);
		
		Product actualProduct = this.myRetailAppServiceImpl.getProductDetails(id);
		Assert.assertEquals(expectedProduct.getName(), actualProduct.getName());
	}
	
	@Test
	public void testRetrieveProductName(){
		String id="15117729";
		
		Map<String, Object> productInfo = new HashMap<String, Object>();
		productInfo.put("title", "Apple iPhone 7 128GB");
		
		Map<String, Object> product_description = new HashMap<String, Object>();
		product_description.put("product_description", productInfo);
		
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("item", product_description);
		
		Map<String, Object> expectedProduct = new HashMap<String, Object>();
		expectedProduct.put("product", item);
		
		Mockito.when(this.restTemplate.getForObject(Mockito.anyString(), Mockito.any(), Mockito.any(Object[].class))).thenReturn(expectedProduct);
		
		String productName = this.myRetailAppServiceImpl.retrieveProductName(id);
		Assert.assertEquals("Apple iPhone 7 128GB", productName);
	}
	
	@Test
	public void testUpdateProductPrice(){
		String id="15117729";
		Double value = 99.99;
		
		Product expectedProduct = new Product();
		expectedProduct.setId(id);
		expectedProduct.setName("Apple iPhone 7 128GB");
		PriceDetail expectedPriceDetail = new PriceDetail();
		expectedPriceDetail.setCurrency_code("USD");
		expectedPriceDetail.setValue(value);
		expectedProduct.setCurrent_price(expectedPriceDetail);
		Mockito.when(this.myRetailAppRepository.updateProductPrice(Mockito.anyString(), Mockito.anyDouble())).thenReturn(expectedProduct);
		
		Product actualProduct = this.myRetailAppServiceImpl.updateProductPrice(id, value);
		Assert.assertEquals(expectedProduct.getCurrent_price().getValue(), actualProduct.getCurrent_price().getValue());
	}

}
