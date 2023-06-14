package com.example.bootdemo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootdemo.dto.Account;
import com.example.bootdemo.repository.AccountRepository;

@RestController
public class AccountController {
@Autowired
AccountRepository ar;

@PostMapping("/save1")
public String saveAccount(@RequestBody Account a)
{
	ar.save(a);
	return "Account saved";
}
@GetMapping("/login")
public String loginvalidation(@RequestBody Account a)
{
	Account account =ar.findByEmailAndPassword(a.getEmail(),a.getPassword());
	if(account!=null)
	{
		return"login successful";
	}
	else 
	{
		return "invalid credentials";
	}
}
}
