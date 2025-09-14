package com.example.sqli.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sqli.model.Product;
import com.example.sqli.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repository;


	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	//
	public void save(Product product) {
		repository.save(product);
	}
	
	//READ 全件取得
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	//セキュア版
	//READ カテゴリー取得
//    public List<Product> findByCategory(String category) {
//        return repository.findByCategory(category);
//    }
	
	
	
	
	
	
	
	//IDでに関連するレコード抽出
	public Product findById(Long id) {
	    return repository.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
	    repository.deleteById(id);
	}
}
