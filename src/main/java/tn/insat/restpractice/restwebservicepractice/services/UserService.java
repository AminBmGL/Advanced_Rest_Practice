package tn.insat.restpractice.restwebservicepractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.insat.restpractice.restwebservicepractice.domain.User;
import tn.insat.restpractice.restwebservicepractice.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserDetails(int id){
		 return userRepository.findById(id).get();
		 
	 }
	
	public User addUser(User user){
		return userRepository.save(user);
	}
	
	
	public void deleteUser(int id){
		 userRepository.deleteById(id);
	}
	
	}
