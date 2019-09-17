package tn.insat.restpractice.restwebservicepractice.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import tn.insat.restpractice.restwebservicepractice.domain.Post;
import tn.insat.restpractice.restwebservicepractice.domain.User;
import tn.insat.restpractice.restwebservicepractice.exceptions.UserNotFoundException;
import tn.insat.restpractice.restwebservicepractice.repositories.PostRepository;
import tn.insat.restpractice.restwebservicepractice.services.UserService;

@RestController
public class UserController {
	
@Autowired	
UserService userService;

@Autowired
PostRepository postRepository;

@GetMapping("/users")
public List<User> getAllUsers(){
	return userService.getAllUsers();
}

@GetMapping("/users/{id}")
public Resource<User> getUser(@PathVariable int id){
	User user = userService.getUserDetails(id);
	
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
public void deleteUser(@PathVariable int id){
	 userService.deleteUser(id);
}	


@GetMapping("/users/{id}/posts")
public List<Post> retrieveAllUsers(@PathVariable int id) {
	User user = userService.getUserDetails(id);
	
	if(user==null) {
		throw new UserNotFoundException("User not found with id-" + id);
	}
	
	return user.getPosts();
}


@PostMapping("/jpa/users/{id}/posts")
public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
	
	User user = userService.getUserDetails(id);
	
	if(user==null) {
		throw new UserNotFoundException("User not found with id-" + id);
	}

	
	post.setUser(user);
	
	postRepository.save(post);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
			.toUri();

	return ResponseEntity.created(location).build();

}

}
