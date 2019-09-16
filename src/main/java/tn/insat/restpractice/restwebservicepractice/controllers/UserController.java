package tn.insat.restpractice.restwebservicepractice.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.insat.restpractice.restwebservicepractice.domain.User;
import tn.insat.restpractice.restwebservicepractice.exceptions.UserNotFoundException;
import tn.insat.restpractice.restwebservicepractice.services.UserService;

@RestController
public class UserController {
	
@Autowired	
UserService userService;

@GetMapping("/users")
public List<User> getAllUsers(){
	return null;
	
}

@GetMapping("/users/{id}")
public Resource<User> getUser(@PathVariable int id){
	User user =userService.getUserDetails(id);
	
	if(user==null) {
		throw new UserNotFoundException("User Not found with Id"+id);
	}
	
	Resource<User> resource=new Resource<User>(user);
	ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).getAllUsers());
	resource.add(linkTo.withRel("all-users"));
	
	return resource;
	
}

@PostMapping("/users")
public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
	User savedUser=userService.addUser(user);
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
