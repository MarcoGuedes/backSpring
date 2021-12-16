package com.backSpring.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backSpring.Models.User;
import com.backSpring.Repo.UserRepo;

@RestController
@RequestMapping("/user")
@CrossOrigin("localhost:4200")
public class UserController {
	@Autowired
	private UserRepo userRep;
	
	 @GetMapping("/all")
	 public List<User> getAllUsers () {
		 return userRep.findAll();
	 }

	 @GetMapping("/find/{id}")
	 public User getUserById (@PathVariable("id") Long id) {
		 return userRep.getById(id);
	 }

	 @GetMapping("/find/{email}")
	 public Optional<User> getUserByEmail (@PathVariable("email") String email) {
		 return userRep.findUserByEmail(email);
	 }
	 
	 @PostMapping("/add")
	 public HttpStatus addUser(@RequestBody User user) {
		 User newUser = userRep.save(user);
		 return HttpStatus.CREATED;
	 }

	 @PutMapping("/update")
	 public HttpStatus updateUser(@RequestBody User user) {
		 User updateUser = userRep.getById(user.getId());
		 userRep.save(updateUser);
		 return HttpStatus.OK;
	 }

	 @DeleteMapping("/delete/{id}")
	 public HttpStatus deleteUser(@PathVariable("id") Long id) {
		 userRep.deleteById(id);
		 return HttpStatus.OK;
	 }
	
}
