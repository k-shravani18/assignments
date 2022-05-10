package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository productRepository;
	
	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getById(int productId)  {
		// TODO Auto-generated method stub
		return productRepository.getById(productId);
	}

	@Override
	public List<Product> getByChoice(String choice)  {
		// TODO Auto-generated method stub
		return productRepository.findByChoice("%"+choice+"%");
	}

	@Override
	public List<Product> getByCategory(String category)  {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> getByLesserprice(double price)  {
		// TODO Auto-generated method stub
		return productRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Product> getByBrandStarting(String brand)  {
		// TODO Auto-generated method stub
		return productRepository.findByBrandStartingWith(brand);
	}

}
