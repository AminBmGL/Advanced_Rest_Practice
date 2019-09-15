package tn.insat.restpractice.restwebservicepractice.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;

import tn.insat.restpractice.restwebservicepractice.domain.User;
import tn.insat.restpractice.restwebservicepractice.services.UserService;

public class UserController {
	
@Autowired	
UserService userService;

@GetMapping("/users")
public List<User> getAllUsers(){
	return null;
	
}

@GetMapping("/users/{id}")
public User getUser(@PathVariable int id){
	
	
	//if user not found throw the usernot found exception
	return null;
	
}

@PostMapping("/users")
public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
	User savedUser=new User();
	URI location=ServletUriComponentsBuilder
	.fromCurrentRequest()
	.path("/{id}")
	.buildAndExpand(savedUser.getId()).toUri();	
	
	
	return ResponseEntity.created(location).build()	;
}


@DeleteMapping("/users/{id}")
public User deleteUser(@PathVariable int id){
	
	//if user not found throw the usernot found exception
	return null;
	
}

}
