package com.SpringBootCURDApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCURDApplication.entity.Users;
import com.SpringBootCURDApplication.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService us;
	
	@GetMapping("/allusers")
	public List<Users> getAllUsers() {
		return us.getAllUsers();
	}
	
	@PostMapping("/saveuser")
	public Users SaveUser(@RequestBody Users user) {
		return us.SaveUser(user);
	}
	
	@PutMapping("/update/{id}")
	public String UpdateUser(@PathVariable int id, @RequestBody Users user) {
		user.setUserid(id);
		return us.UpdateUser(user);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String DeleteUser(@PathVariable("id") int id) {
		return us.DeleteUser(id);
	}
	
	@PostMapping("/users/{password}")
	public ResponseEntity<String> UserWithEncryptedPassword(@PathVariable String userName, @PathVariable String password) {
		Users user =us.UserWithEncryptedPassword(userName,password); 
		int id=user.getUserid();
		return ResponseEntity.ok("User created with id: "+id);
	}
	
	@GetMapping("/users/{password}")
	public ResponseEntity<String> findByUserNamebyDecryptionofpassword(@PathVariable String userName, @PathVariable String password) {
		boolean user =us.findByUserNamebyDecryptionofpassword(userName,password);
		if(user)
		{
			return ResponseEntity.ok("Valid user");
		}
		else {
			return ResponseEntity.badRequest().body("Invalid user");
		}
	}
}
