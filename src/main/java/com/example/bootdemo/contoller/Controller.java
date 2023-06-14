package com.example.bootdemo.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootdemo.dto.Student;
import com.example.bootdemo.repository.StudentRepository;
@RestController
public class Controller {
	@Autowired
	StudentRepository sr;
@PostMapping("/hi")
public String m1()
{
	return "hello good evening";
	
}
@GetMapping("/hello")
public void m2()
{
	System.out.println("get response is handled");
}
@PostMapping("/savedata")
public String save(@RequestBody Student s)
{
	sr.save(s);
	return "data save successfully";
	
}
@GetMapping("/fetchdata")
public Student fetchStudentById(@RequestParam int id)
{
	 Optional<Student> ou=sr.findById(id);
	 Student s=ou.get();
	 
	return s;
}
	@GetMapping("/findstudentbyname")
	public List<Student>fetchByName(String name)
	{
		List<Student> students=sr.findByName(name);
		return students;
	}
	
	@GetMapping("/findallstudent")
	public List<Student>fetchAllStudent()
	{
		List<Student> students=sr.findAll();
		return students;
	}
	@GetMapping("/fetchstusentagegreaterthan")
	public List<Student>findByAgeGreaterThan(@RequestParam int age)
	{
		List<Student> students=sr.findByAgeGreaterThan(age);
		return students;
	}
	@GetMapping("/fetchstudentlessthan")
	public List<Student>finfByAgeLessThan(@RequestParam int age)
	{
		List<Student> students=sr.findByAgeLessThan(age);
		return students;
	}
	@DeleteMapping("/delete")
	public String deletestudent(@RequestParam int id)
	{
		sr.deleteById(id);
		return"data deleted Successfully";
	}
	@DeleteMapping("/deleteall")
	public String deleteallstudent()
	{
		sr.deleteAll();
		return " All data deleted Successfully";
	}
	@PutMapping("/updatedata")
	public String updatestudent(@RequestBody Student s)
	{
		sr.save(s);
		return "data update succesfully";
	}
	
	@GetMapping("/fetchdatabyageequals")
	public List<Student>studentageequals(@RequestParam int age)
	{
		return sr.findByAgeEquals(age);
	}
	
	@GetMapping("/fetchdatabyagegraeterthenequql")
	public List<Student>findagegreatethanequl(@RequestParam int age)
	{
		return sr.findByAgeGreaterThanEqual(age);
	}
	
	@GetMapping("/fetchdatabyagelessthanequal")
	public List<Student>findbyagelessthanequal(@RequestParam int age)
	{
		return sr.findByAgeLessThanEqual(age);
	}
	
	
//	@GetMapping("/fetchdatabyagebetween")
//	public List<Student>findagebetween(@RequestParam int ag1,int age2)
//	{
//		return sr.findByAgeBetween(age2, age2);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	


