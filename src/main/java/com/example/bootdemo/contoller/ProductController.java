package com.example.bootdemo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootdemo.dto.Product;
import com.example.bootdemo.repository.PriceRepository;

@RestController
public class ProductController {
@Autowired
     PriceRepository pr;



@PostMapping("/saveproduct")
public  String saveproduct(@RequestBody Product p)
{
	pr.save(p);
	return "Product save successfully";
}
@GetMapping("/catagory")
public List<Product>fetchdatabycatagory(@RequestParam String catagory)
{
	
List<Product> product=pr.findByCatagory(catagory);
return product;




}   

}

