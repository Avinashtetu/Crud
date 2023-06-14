package com.example.bootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootdemo.dto.Product;

public interface PriceRepository extends JpaRepository<Product, Integer>{
	
	List<Product>findByCatagory(String catagory);

}
